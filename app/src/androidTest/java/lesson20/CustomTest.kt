package lesson20

import lesson18.screens.SearchScreen.SearchScreen
import lesson18.screens.explore.ExploreScreen
import lesson18.screens.onboarding.OnboardingScreen
import lesson18.utils.BaseTest
import lesson19.ext.action
import lesson19.ext.verify
import org.junit.Test

class CustomTest : BaseTest() {

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