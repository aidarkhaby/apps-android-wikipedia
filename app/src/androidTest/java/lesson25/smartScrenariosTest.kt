package lesson25

import io.github.kakaocup.kakao.text.TextViewAssertions
import lesson18.screens.ThemeBottomSheet.ThemeBottomSheet
import lesson18.screens.ThemeBottomSheet.ThemeBottomSheet.invoke
import lesson18.screens.ThemeBottomSheet.ThemeBottomSheet.themeWidget
import lesson18.screens.explore.ExploreScreen
import lesson18.screens.onboarding.OnboardingScreen
import lesson18.utils.BaseTest
import lesson19.ext.action
import lesson19.ext.verify
import org.junit.Test

class smartScrenariosTest : BaseTest() {

    @Test
    fun themeWidgetChangeTextSizeTestWithSmartScenarios() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                cardListItem(0) {
                    action {
                        click(image)
                        click(this@topReadBlock.themeButton)
                    }
                }
            }
            ThemeBottomSheet {
                themeWidget{
                    verify.isDisplayed(this)
                    action.click(increaseSizeButton)
                    verify.hasText(textSize as TextViewAssertions, "110%")
                    repeat(2){
                        action.click(decreaseSizeButton)
                    }
                    verify.hasText(textSize as TextViewAssertions, "90%")
                }
            }
        }
    }
}