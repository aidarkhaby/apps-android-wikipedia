package lesson19

import lesson17.BaseTest
import lesson18.screens.explore.ExploreScreen
import lesson19.ext.action
import lesson19.ext.verify
import org.junit.Test
import org.wikipedia.lesson03.homeworks.OnboardingScreen

class SimpleTest : BaseTest() {

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
    fun imageTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.customizeBlock {
                verify.isDisplayed(this)
            }
        }
    }

    @Test
    fun toggleTest() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.customizeBlock {
                verify.isDisplayed(this)
            }
        }
    }
}