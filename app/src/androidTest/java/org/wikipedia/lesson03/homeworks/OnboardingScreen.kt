package org.wikipedia.lesson03.homeworks

import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.onboarding.OnboardingPageView
import org.wikipedia.views.AppTextView

object OnboardingScreen: KScreen<OnboardingScreen>() {
    val skipButton = KButton{
        withId(R.id.fragment_onboarding_skip_button)
    }

    val continueButton = KButton{
        withId(R.id.fragment_onboarding_forward_button)
    }

    val imageOnboardingPage = listOf(
        AppCompatImageView::class.java,
        R.id.imageViewCentered,
        R.drawable.illustration_onboarding_explore
    )
    val primaryText = listOf(
        AppTextView::class.java,
        R.id.primaryTextView,
        R.string.onboarding_welcome_title_v2
    )
    val secondaryText = listOf(
        AppTextView::class.java,
        R.id.secondaryTextView,
        R.string.onboarding_multilingual_secondary_text
    )
    val labelText = listOf(
        AppTextView::class.java,
        R.id.option_label
    )
    val addLanguageButton = listOf(
        MaterialButton::class.java,
        R.id.addLanguageButton,
        R.string.onboarding_multilingual_add_language_text
    )
    val tabKarusel = listOf(
        TabLayout::class.java,
        R.id.view_onboarding_page_indicator
    )

    val imageOnboardingSecondPage = listOf(
        AppCompatImageView::class.java,
        R.id.imageViewCentered,
        R.drawable.illustration_onboarding_explore
    )
    val primaryTextSecondPage = listOf(
        AppTextView::class.java,
        R.id.primaryTextView
    )
    val secondaryTextSecondPage = listOf(
        AppTextView::class.java,
        R.id.secondaryTextView
    )
    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = OnboardingPageView::class.java

}