package lesson22.Tests

import lesson18.screens.explore.ExploreScreen
import lesson18.screens.onboarding.OnboardingScreen
import lesson18.utils.BaseTest
import lesson19.ext.action
import lesson19.ext.verify
import org.junit.Test

class WidgetTest : BaseTest() {

    @Test
    fun searchWidgetTest() {
        run{
            action.click(OnboardingScreen.skipButton)
            verify {
                ExploreScreen.searchWidget {
                    isDisplayed(this)
                    isDisplayed(searchIcon)
                    hasText(searchText, "Search Wikipedia")
                    isDisplayed(voiceIcon)
                }
            }
        }
    }
}