package lesson24

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import lesson18.screens.onboarding.OnboardingScreen
import lesson18.utils.BaseTest
import lesson19.ext.action
import lesson19.ext.verify
import lesson24.screen.AddLanguageScreen
import lesson24.screen.LanguageItem
import lesson24.screen.YourLanguagesScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class ComposeTest : BaseTest() {



    @get:Rule(order = 2)
    val kakaoRule = KakaoComposeTestRule()

    private val localizedLanguageName = "Deutsch"
    private val canonicalLanguageName = "German"

    @Test
    fun addLanguageTest() {
        run {
            action.click(OnboardingScreen.addLanguageButton)
            action.click(YourLanguagesScreen.addLanguage)

            AddLanguageScreen {
                Thread.sleep(1000)
                items.invokeWithText<LanguageItem>(localizedLanguageName) {
                    localName.assertTrimmedTextIsEquals(localizedLanguageName)
                    canonicName.assertTrimmedTextIsEquals(canonicalLanguageName)
                    clickIfEnabled()
                }
            }
            action.click(YourLanguagesScreen.backToolbarButton)
            OnboardingScreen.page(0) {
                languagesBlockByIndex(2){
                    verify.hasText(this, "2.\t\tDeutsch")
                }
            }
        }
    }

}