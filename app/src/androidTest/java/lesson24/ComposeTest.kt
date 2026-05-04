package lesson24

import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import lesson18.screens.onboarding.OnboardingScreen
import lesson18.utils.BaseTest
import lesson19.ext.action
import lesson24.screen.AddLanguageScreen
import lesson24.screen.LanguageItem
import lesson24.screen.YourLanguagesScreen
import org.junit.Rule
import org.junit.Test

class ComposeTest : BaseTest() {

    @get:Rule
    val composeTestRule = KakaoComposeTestRule()

    private val localizedLanguageName = "Deutsch"
    private val canonicalLanguageName = "German"

    @Test
    fun addLanguageTest(){
        run {
            action.click(OnboardingScreen.addLanguageButton)
            action.click(YourLanguagesScreen.addLanguage)

            AddLanguageScreen{
                items.invokeWithText<LanguageItem>(localizedLanguageName) {
                    localName.assertTrimmedTextIsEquals(localizedLanguageName)
                    canonicName.assertTrimmedTextIsEquals(canonicalLanguageName)
                    clickIfEnabled()
                }
            }
            //verify.isVisible(OnboardingScreen.languageItem(localizedLanguageName))
        }
    }


}