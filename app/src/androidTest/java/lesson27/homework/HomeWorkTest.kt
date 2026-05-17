package lesson27.homework

import lesson18.utils.BaseTest
import org.junit.Rule
import org.junit.Test


class HomeWorkTest(): BaseTest() {

    @get:Rule
    val baseRule = DeprecatedTestRule()

    // Обычный тест - должен выполниться успешно
    @Test
    fun testActive() {
        println("Executing active test")
        // Тут может быть ваша логика теста
    }

    // Помеченный @Deprecated тест - должен быть пропущен (skipped)
    @Test
    @Deprecated("This test is outdated, please use new test instead")
    fun testDeprecatedWithMessage() {
        // Этот код не выполнится из-за AssumptionViolatedException
        println("This line will never be printed")
    }

    // Ещё один помеченный @Deprecated тест без сообщения
    @Test
    @Deprecated("")
    fun testDeprecatedWithoutMessage() {
        println("This line will never be printed either")
    }

    // Ещё один обычный тест для демонстрации
    @Test
    fun testAnotherActive() {
        println("Executing another active test")
    }
}