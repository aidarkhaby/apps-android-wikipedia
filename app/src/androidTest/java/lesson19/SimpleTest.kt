package lesson19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import lesson18.screens.explore.ExploreScreen
import lesson18.screens.onboarding.OnboardingScreen
import lesson19.ext.action
import lesson19.ext.verify
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class SimpleTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    /*
    @Test
    fun example() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.customizeBlock {
                verify.isDisplayed(this)
            }
        }
    }

    @Test
    fun imageTopReadTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                cardListItem(2) {
                    verify.isDisplayed(image)
                }
            }
        }
    }

     */

    @Test
    fun toggleTest() {
        run {

        }
    }
}