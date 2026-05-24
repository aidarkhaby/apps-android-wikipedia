#!/bin/bash

# Цвета для вывода
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${GREEN}=== Android Test Automation Script ===${NC}"

# Пути к Android SDK
ANDROID_SDK="/Users/aidarkhabibulin/Library/Android/sdk"
EMULATOR="$ANDROID_SDK/emulator/emulator"
AVD_MANAGER="$ANDROID_SDK/cmdline-tools/latest/bin/avdmanager"
SDK_MANAGER="$ANDROID_SDK/cmdline-tools/latest/bin/sdkmanager"
ADB="$ANDROID_SDK/platform-tools/adb"

# Параметры эмулятора
AVD_NAME="emulator-arm64"
API_LEVEL="33"

# Определяем архитектуру процессора
if [[ $(uname -m) == 'arm64' ]]; then
    ARCH="arm64-v8a"
    SYSTEM_IMAGE="system-images;android-$API_LEVEL;google_apis;arm64-v8a"
else
    ARCH="x86_64"
    SYSTEM_IMAGE="system-images;android-$API_LEVEL;google_apis;x86_64"
fi

DEVICE="pixel_6"

echo -e "${YELLOW}Detected architecture: $ARCH${NC}"
echo -e "${YELLOW}System image: $SYSTEM_IMAGE${NC}"

# Функция для проверки ошибок
check_error() {
    if [ $? -ne 0 ]; then
        echo -e "${RED}Error: $1${NC}"
        exit 1
    fi
}

# Функция для проверки, загрузился ли эмулятор
wait_for_boot() {
    echo -e "${YELLOW}Waiting for emulator to boot...${NC}"
    $ADB wait-for-device
    sleep 10

    # Ждём, пока boot complete
    while true; do
        BOOT_COMPLETED=$($ADB shell getprop sys.boot_completed 2>/dev/null | tr -d '\r')
        if [ "$BOOT_COMPLETED" == "1" ]; then
            echo -e "${GREEN}✓ Emulator boot completed${NC}"
            break
        fi
        echo -n "."
        sleep 2
    done
}

# 1. Создание эмулятора
echo -e "${YELLOW}1. Creating Android emulator...${NC}"

# Проверяем, существует ли уже эмулятор
if $EMULATOR -list-avds 2>/dev/null | grep -q "^$AVD_NAME$"; then
    echo -e "${YELLOW}Emulator $AVD_NAME already exists. Deleting...${NC}"
    echo "no" | $AVD_MANAGER delete avd -n $AVD_NAME
    check_error "Failed to delete existing AVD"
fi

# Устанавливаем системный образ (если не установлен)
echo -e "${YELLOW}Installing system image...${NC}"
$SDK_MANAGER --install "$SYSTEM_IMAGE" <<< "y" 2>/dev/null
check_error "Failed to install system image"

# Создаём AVD
echo -e "${YELLOW}Creating AVD...${NC}"
echo "no" | $AVD_MANAGER create avd \
    -n "$AVD_NAME" \
    -k "$SYSTEM_IMAGE" \
    -d "$DEVICE" \
    -f

check_error "Failed to create AVD"

echo -e "${GREEN}✓ Emulator created successfully${NC}"

# 2. Запуск эмулятора
echo -e "${YELLOW}2. Starting emulator...${NC}"

# Запускаем эмулятор в фоновом режиме
$EMULATOR -avd "$AVD_NAME" \
    -no-snapshot \
    -wipe-data \
    -gpu auto \
    -no-audio \
    -no-boot-anim \
    -port 5584 &

EMULATOR_PID=$!
echo -e "${YELLOW}Emulator started with PID: $EMULATOR_PID${NC}"

# 3. Ждём загрузки эмулятора
echo -e "${YELLOW}3. Waiting for emulator to boot...${NC}"
wait_for_boot
echo -e "${GREEN}✓ Emulator is ready${NC}"

# 4. Запуск теста
echo -e "${YELLOW}4. Running tests...${NC}"
./gradlew app:connectedAlfaDebugAndroidTest \
    -Pandroid.testInstrumentationRunnerArguments.class=lesson26.HwTest#sampleTest

TEST_EXIT_CODE=$?

if [ $TEST_EXIT_CODE -eq 0 ]; then
    echo -e "${GREEN}✓ Tests passed successfully${NC}"
else
    echo -e "${RED}✗ Tests failed with exit code: $TEST_EXIT_CODE${NC}"
fi

# 5. Завершение работы эмулятора
echo -e "${YELLOW}5. Stopping emulator...${NC}"
$ADB emu kill
sleep 2
kill $EMULATOR_PID 2>/dev/null
echo -e "${GREEN}✓ Emulator stopped${NC}"

# 6. Генерация Allure отчёта
echo -e "${YELLOW}6. Generating Allure report...${NC}"

# Проверка установки Allure
if ! command -v allure &> /dev/null; then
    echo -e "${RED}Allure is not installed. Installing via Homebrew...${NC}"
    brew install allure
    check_error "Failed to install Allure"
fi

# Поиск папки с результатами Allure
ALLURE_RESULTS=$(find . -type d -name "allure-results" 2>/dev/null | head -1)

if [ -n "$ALLURE_RESULTS" ]; then
    echo -e "${YELLOW}Found Allure results at: $ALLURE_RESULTS${NC}"
    echo -e "${YELLOW}Generating report...${NC}"
    allure generate "$ALLURE_RESULTS" -o allure-report --clean
    check_error "Failed to generate Allure report"

    echo -e "${YELLOW}Opening report in browser...${NC}"
    allure open allure-report
    echo -e "${GREEN}✓ Allure report generated and opened${NC}"
else
    echo -e "${RED}Allure results not found${NC}"
    echo -e "${YELLOW}Looking in common locations...${NC}"

    # Проверяем стандартные пути
    if [ -d "app/build/outputs/allure-results" ]; then
        ALLURE_RESULTS="app/build/outputs/allure-results"
        allure generate "$ALLURE_RESULTS" -o allure-report --clean
        allure open allure-report
    elif [ -d "build/allure-results" ]; then
        ALLURE_RESULTS="build/allure-results"
        allure generate "$ALLURE_RESULTS" -o allure-report --clean
        allure open allure-report
    else
        echo -e "${RED}No allure-results directory found. Skipping report generation.${NC}"
    fi
fi

echo -e "${GREEN}=== Script completed ===${NC}"
exit $TEST_EXIT_CODE