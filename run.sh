#!/bin/bash

# Цвета для вывода
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Конфигурация
IMAGE_NAME="android-builder:latest"
CONTAINER_NAME="android-builder-container"

echo -e "${GREEN}=== Docker Android Builder Script ===${NC}"

# 1. Сборка образа
echo -e "${YELLOW}1. Building Docker image...${NC}"
docker build -t $IMAGE_NAME .

if [ $? -ne 0 ]; then
    echo -e "${RED}Failed to build image${NC}"
    exit 1
fi
echo -e "${GREEN}✓ Image built successfully${NC}"

# 2. Остановка и удаление существующего контейнера (если есть)
echo -e "${YELLOW}2. Cleaning up existing container...${NC}"
docker stop $CONTAINER_NAME 2>/dev/null
docker rm $CONTAINER_NAME 2>/dev/null
echo -e "${GREEN}✓ Cleanup completed${NC}"

# 3. Запуск контейнера в фоновом режиме
echo -e "${YELLOW}3. Starting container...${NC}"
docker run --rm -d \
    --name $CONTAINER_NAME \
    -v "$(pwd):/project" \
    -w /project \
    $IMAGE_NAME \
    sleep infinity

if [ $? -ne 0 ]; then
    echo -e "${RED}Failed to start container${NC}"
    exit 1
fi
echo -e "${GREEN}✓ Container started successfully (name: $CONTAINER_NAME)${NC}"

# 4. Запуск очистки сборочной директории
echo -e "${YELLOW}4. Running clean command inside container...${NC}"
docker exec $CONTAINER_NAME sh -c "sed -i 's/\r$//' gradlew && chmod +x gradlew && ./gradlew app:clean"

if [ $? -ne 0 ]; then
    echo -e "${RED}Clean command failed${NC}"
    exit 1
fi

echo -e "${GREEN}✓ Clean completed successfully${NC}"
echo -e "${GREEN}=== Script finished ===${NC}"