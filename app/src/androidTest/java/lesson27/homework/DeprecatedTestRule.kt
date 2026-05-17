package lesson27.homework

import android.util.Log
import io.qameta.allure.kotlin.AllureId
import lesson27.Config
import org.junit.AssumptionViolatedException
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement


class DeprecatedTestRule : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        Log.i("KASPRESSO", "Before TEST RULE STARTED")
        Log.i("KASPRESSO", description?.displayName ?: "")

        return object : Statement() {
            override fun evaluate() {
                    // Проверяем наличие аннотации @Deprecated у метода теста
                    val deprecatedAnnotation = description?.getAnnotation(Deprecated::class.java)

                    if (deprecatedAnnotation != null) {
                        // Если аннотация есть, читаем сообщение из неё
                        val message = deprecatedAnnotation.message
                        val skipMessage = if (message.isNotEmpty()) {
                            "Test is deprecated: $message"
                        } else {
                            "Test is deprecated (no message provided)"
                        }

                        // Выбрасываем AssumptionViolatedException, чтобы пропустить тест
                        throw AssumptionViolatedException(skipMessage)
                    }

                    // Если аннотации нет, выполняем тест как обычно
                base?.evaluate()
            }
        }
    }
}