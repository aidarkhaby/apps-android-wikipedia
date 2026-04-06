package lesson17

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson03.homeworks.OnboardingScreen
import org.wikipedia.main.MainActivity

class TestForAllureReport : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testForAllure() {
        run {
            step("Проверяет, что кнопка skip отображается"){
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Проверяет, что текст отображается"){
                OnboardingScreen.primaryText.isNotEmpty()
            }
        }
    }

    @Test
    fun testFailedForAllureReport() {
        run {
            step("Проверяет, что кнопка skip НЕ отображается"){
                OnboardingScreen.skipButton.isNotDisplayed()
            }
        }
    }
}