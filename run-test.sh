#!/bin/bash

# Цветной вывод для лучшей читаемости
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m'

print_green() { echo -e "${GREEN}$1${NC}"; }
print_red() { echo -e "${RED}$1${NC}"; }
print_yellow() { echo -e "${YELLOW}$1${NC}"; }

# Пути (настройте под свой проект)
PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
APK_OUTPUT_DIR="$PROJECT_DIR/app/build/outputs/apk"
MARATHON_CLI="$PROJECT_DIR/marathon-cli/bin/marathon"
MARATHONFILE="$PROJECT_DIR/Marathonfile"

# Имена эмуляторов (должны быть созданы в Android Studio AVD Manager)
EMULATORS=("Pixel_3a_API_30" "Pixel_4_API_30")
EMULATOR_WAIT_TIMEOUT=180  # секунд на загрузку

print_yellow "=== Запуск Marathon тестов ==="

# Шаг 1: Компиляция APK
print_green "[1/5] Компиляция приложения и тестов..."
cd "$PROJECT_DIR"
./gradlew clean assembleDebug assembleDebugAndroidTest

if [ $? -ne 0 ]; then
    print_red "❌ Ошибка компиляции!"
    exit 1
fi
print_green "✅ Компиляция завершена"

# Шаг 2: Запуск эмуляторов
print_green "[2/5] Запуск эмуляторов..."
for EMU in "${EMULATORS[@]}"; do
    # Проверяем, не запущен ли уже
    if ! emulator -list-avds | grep -q "^$EMU$"; then
        print_red "❌ Эмулятор $EMU не найден. Создайте его в AVD Manager."
        exit 1
    fi

    # Запускаем эмулятор в фоне
    nohup emulator -avd "$EMU" -no-snapshot -no-audio > "/tmp/emulator_$EMU.log" 2>&1 &
    print_green "   Запущен эмулятор: $EMU (PID: $!)"
done

# Шаг 3: Ожидание полной загрузки эмуляторов
print_green "[3/5] Ожидание загрузки эмуляторов (максимум ${EMULATOR_WAIT_TIMEOUT} сек)..."

# Функция проверки boot_completed
wait_for_emulator() {
    local serial=$1
    local timeout=$2
    local start_time=$(date +%s)

    while true; do
        local current_time=$(date +%s)
        if [ $((current_time - start_time)) -gt $timeout ]; then
            print_red "❌ Таймаут загрузки для $serial"
            return 1
        fi

        local boot_completed=$(adb -s "$serial" shell getprop sys.boot_completed 2>/dev/null | tr -d '\r')
        local boot_completed_anim=$(adb -s "$serial" shell getprop init.svc.bootanim 2>/dev/null | tr -d '\r')

        if [ "$boot_completed" == "1" ] && [ "$boot_completed_anim" == "stopped" ]; then
            print_green "✅ $serial загружен"
            return 0
        fi
        sleep 5
    done
}

# Получаем список подключенных устройств
sleep 10  # даём время эмуляторам появиться в adb
adb devices | grep -E "emulator-[0-9]+" | awk '{print $1}' | while read serial; do
    wait_for_emulator "$serial" $EMULATOR_WAIT_TIMEOUT
done

print_green "✅ Все эмуляторы загружены"

# Шаг 4: Запуск Marathon
print_green "[4/5] Запуск Marathon..."
"$MARATHON_CLI" -m "$MARATHONFILE"

MARATHON_EXIT_CODE=$?
if [ $MARATHON_EXIT_CODE -ne 0 ]; then
    print_red "❌ Marathon завершился с ошибкой (код: $MARATHON_EXIT_CODE)"
else
    print_green "✅ Marathon успешно завершён"
fi

# Шаг 5: Остановка эмуляторов
print_green "[5/5] Остановка эмуляторов..."
adb devices | grep -E "emulator-[0-9]+" | awk '{print $1}' | while read serial; do
    adb -s "$serial" emu kill
    print_green "   Остановлен: $serial"
done

print_green "=== Готово ==="
exit $MARATHON_EXIT_CODE