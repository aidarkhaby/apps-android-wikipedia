package lesson10.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class UiOnboardingTest: TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkSkipButton(){
        run{
            OnboardingUiScreen.skip.isDisplayed()
        }
    }

    @Test
    fun checkTitleTextSecondSlide(){
        run {
            OnboardingUiScreen {
                screenSwipe.swipeLeft()
                titleText.containsText("New ways to explore")
        }
        }
    }

    @Test
    fun checkSubtitleTextSecondSlide(){
        run {
            OnboardingUiScreen {
                screenSwipe.swipeLeft()
                subtitleText.containsText("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed.")
            }
        }
    }

    @Test
    fun checkTitleTextThirdSlide(){
        run {
            OnboardingUiScreen {
                screenSwipe{
                    swipeLeft()
                    swipeLeft()
                }
                titleText.containsText("Reading lists with sync")
            }
        }
    }

    @Test
    fun checkSubtitleTextThirdSlide(){
        run {
            OnboardingUiScreen {
                screenSwipe{
                    swipeLeft()
                    swipeLeft()
                }
                subtitleText.containsText("Login to your Wikipedia account to sync your reading lists. Join Wikipedia")
            }
        }
    }

}