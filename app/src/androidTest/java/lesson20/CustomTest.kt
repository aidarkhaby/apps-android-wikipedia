package lesson20

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import lesson18.screens.SearchScreen.SearchScreen
import lesson18.screens.explore.ExploreScreen
import lesson18.screens.onboarding.OnboardingScreen
import lesson19.ext.action
import lesson19.ext.verify
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class CustomTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun customAssertActionTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
            ExploreScreen {
                verify.isDisplayed(searchField)
                action.click(searchField)
            }
            SearchScreen {
                searchField {
                    multiAction(text)
                    equalsWithTrim(text)
                }
            }
            repeat(2) {
                device.uiDevice.pressBack()
            }
            ExploreScreen {
                action.apply {

                }
            }
        }
    }

}