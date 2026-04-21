package lesson21


import lesson18.screens.MoreBottomSheet.MoreBottomSheet
import lesson18.screens.SettingsScreen.SettingsItem
import lesson18.screens.SettingsScreen.SettingsScreen
import lesson18.screens.TabBar.TabBar
import lesson18.screens.onboarding.OnboardingScreen
import lesson18.utils.BaseTest
import org.junit.Test
import org.wikipedia.R


class TestSettings : BaseTest() {

    @Test
    fun checkSettingsSwitcher() {
        OnboardingScreen.skipButton.click()
        TabBar.moreTab.click()
        MoreBottomSheet.settings.click()
        SettingsScreen.items.invokeAtIndexAndId<SettingsItem>(
            1, R.id.switchWidget,
            limit = 20,
            startWith = 0
        ){
            switcher.isChecked()
        }
        SettingsScreen.items.invokeAtIndexAndId<SettingsItem>(
            2, R.id.right_icon,
            limit = 22,
            startWith = 15
        ){
            title.hasText("Terms of use")
        }
    }
}