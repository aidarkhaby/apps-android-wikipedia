FROM ubuntu:24.04
ENV DEBIAN_FRONTEND=noninteractive
ENV ANDROID_HOME=/opt/android-sdk
ENV ANDROID_SDK_ROOT=/opt/android-sdk
ENV PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin
ENV PATH=$PATH:$ANDROID_HOME/platform-tools
ENV PATH=$PATH:$ANDROID_HOME/emulator
RUN apt-get update && apt-get install -y \
   openjdk-21-jdk \
   wget \
   unzip \
   git \
   curl \
   && rm -rf /var/lib/apt/lists/*
RUN mkdir -p $ANDROID_HOME/cmdline-tools
RUN wget -O sdk.zip \
 https://dl.google.com/android/repository/commandlinetools-linux-13114758_latest.zip
RUN unzip sdk.zip -d /tmp/sdk
RUN mv /tmp/sdk/cmdline-tools \
 $ANDROID_HOME/cmdline-tools/latest
RUN yes | sdkmanager --licenses
RUN sdkmanager \
    "platform-tools" \
    "platforms;android-35" \
    "build-tools;35.0.0" \
    "emulator" \
    "system-images;android-35;google_apis;x86_64"
