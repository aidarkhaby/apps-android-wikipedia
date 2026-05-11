package lesson26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import lesson18.screens.onboarding.OnboardingScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class HwTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        testRunWatcherInterceptors.add(HomeworkInterceptor())
    }
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun sampleTest() {
        before {
            testLogger.i("Before block started")
            device.uiDevice.wakeUp()
            device.uiDevice.isNaturalOrientation
        }

        run {
            testLogger.i("Run block started")
            step("test interceptors") {
                OnboardingScreen.continueButton {
                    isDisplayed()
                    click()
                }
            }
        }
    }
}
