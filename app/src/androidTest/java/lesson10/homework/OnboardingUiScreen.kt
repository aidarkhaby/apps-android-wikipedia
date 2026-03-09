package lesson10.homework

import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen: UiScreen<OnboardingUiScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val skip = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val titleText = UiTextView{
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }

    val subtitleText = UiTextView{
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val screenSwipe = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "scrollViewContainer")
    }

}