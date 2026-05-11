package lesson26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import lesson18.screens.explore.ExploreScreen
import lesson18.screens.onboarding.OnboardingScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class SampleTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply{
        stepWatcherInterceptors.removeIf{
            it is ScreenshotStepInterceptor
        }
        stepWatcherInterceptors.add(ScreenshotStepOnlyFailInterceptor(screenshots))
    }
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun sampleTest() {
        run {
            step("test") {
                OnboardingScreen.continueButton {
                    isDisplayed()
                    click()
                }
            }
            step("fail"){
                ExploreScreen.items.isDisplayed()
            }
        }
    }
}