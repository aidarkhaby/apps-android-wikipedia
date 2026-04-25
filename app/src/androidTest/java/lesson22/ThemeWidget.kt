package lesson22

import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import lesson18.extensions.name
import lesson18.extensions.withParent
import org.wikipedia.R


class ThemeWidget(builder: ViewBuilder.() -> Unit) :
    KWidget<ThemeWidget>(builder) {

    val decreaseSizeButton by lazy {
        KTextView(matcher) {
            withId(R.id.buttonDecreaseTextSize)
        }.name(withParent("Уменьшение шрифта"))
    }

    val increaseSizeButton by lazy {
        KTextView(matcher) {
            withId(R.id.buttonIncreaseTextSize)
        }.name(withParent("Увеличение шрифта"))
    }

    val textSizeSeekBar by lazy {
        KSeekBar(matcher) {
            withId(R.id.text_size_seek_bar)
        }.name(withParent("Бар изменения размера шрифта"))
    }

    val readingFocusModeSwitcher by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_reading_focus_mode_switch)
        }.name(withParent("Тогл reading focus mode"))
    }

    val lightThemeButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_light)
        }.name(withParent("Кнопка светлой темы"))
    }

    val sepiaThemeButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_sepia)
        }.name(withParent("Кнопка темы сепия"))
    }

    val  darkThemeButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_dark)
        }.name(withParent("Кнопка темной темы"))
    }

    val blackThemeButton by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_black)
        }.name(withParent("Кнопка черной темы"))
    }

    val matchSystemThemeSwitcher by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_match_system_theme_switch)
        }.name(withParent("Тогл Match system theme"))
    }

    val textSize by lazy {
        KTextView(matcher) {
            withId(R.id.text_size_percent)
        }.name(withParent("Процент увеличения текста"))
    }

}