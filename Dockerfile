# Базовый образ с JDK 21
FROM eclipse-temurin:21-jdk

# Установка необходимых пакетов
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    curl \
    git \
    && rm -rf /var/lib/apt/lists/*

# Установка переменных окружения для Android SDK
ENV ANDROID_SDK_ROOT=/opt/android-sdk \
    ANDROID_HOME=/opt/android-sdk \
    PATH=$PATH:/opt/android-sdk/cmdline-tools/latest/bin:/opt/android-sdk/platform-tools

# Создание директории для Android SDK
RUN mkdir -p ${ANDROID_SDK_ROOT}

# Скачивание и установка command line tools (только инструменты, без эмулятора и образов ОС)
RUN cd ${ANDROID_SDK_ROOT} && \
    wget -q https://dl.google.com/android/repository/commandlinetools-linux-13114758_latest.zip && \
    unzip commandlinetools-linux-*.zip && \
    rm commandlinetools-linux-*.zip && \
    mkdir -p ${ANDROID_SDK_ROOT}/cmdline-tools && \
    mv ${ANDROID_SDK_ROOT}/cmdline-tools ${ANDROID_SDK_ROOT}/cmdline-tools/latest 2>/dev/null || \
    (mkdir -p ${ANDROID_SDK_ROOT}/temp && \
     mv ${ANDROID_SDK_ROOT}/cmdline-tools ${ANDROID_SDK_ROOT}/temp && \
     mkdir -p ${ANDROID_SDK_ROOT}/cmdline-tools && \
     mv ${ANDROID_SDK_ROOT}/temp/cmdline-tools ${ANDROID_SDK_ROOT}/cmdline-tools/latest)

# Принимаем лицензии (автоматически)
RUN yes | ${ANDROID_SDK_ROOT}/cmdline-tools/latest/bin/sdkmanager --licenses > /dev/null 2>&1 || true

# Устанавливаем минимально необходимые компоненты Android SDK (БЕЗ эмулятора и образов ОС)
RUN ${ANDROID_SDK_ROOT}/cmdline-tools/latest/bin/sdkmanager \
    "platform-tools" \
    "build-tools;34.0.0" \
    "platforms;android-34" > /dev/null 2>&1

# Установка Gradle (опционально, можно использовать обёртку из проекта)
RUN wget -q https://services.gradle.org/distributions/gradle-8.5-bin.zip && \
    unzip gradle-8.5-bin.zip -d /opt && \
    rm gradle-8.5-bin.zip && \
    ln -s /opt/gradle-8.5/bin/gradle /usr/local/bin/gradle

# Рабочая директория по умолчанию
WORKDIR /project

# Команда по умолчанию (будет переопределена при запуске)
CMD ["sleep", "infinity"]