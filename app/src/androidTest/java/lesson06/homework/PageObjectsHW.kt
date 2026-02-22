package lesson06.homework

import androidx.appcompat.widget.AppCompatImageView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object PageObjectsHW : KScreen<PageObjectsHW>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val textSettings = KTextView {
        withId(R.id.textSettingsCategory)
    }

    val textSizePercent = KTextView {
        withId(R.id.text_size_percent)
    }

    val buttonDecrease = KTextView {
        withId(R.id.buttonDecreaseTextSize)
    }

    val buttonIncrease = KTextView {
        withId(R.id.buttonIncreaseTextSize)
    }

    val discreteSeekBar = KView {
        withId(R.id.text_size_seek_bar)
    }

    val sansSerifButton = KButton {
        withId(R.id.button_font_family_sans_serif)
    }

    val serifButton = KButton {
        withId(R.id.button_font_family_serif)
    }

    val glassImage = KImageView {
        withParent {
            withId(R.id.readingFocusModeContainer)
        }
        isInstanceOf(AppCompatImageView::class.java)
    }

    val readingFocusModeSwitch = KCheckBox {
        withId(R.id.theme_chooser_reading_focus_mode_switch)
    }

    val readingFocusModeDescription = KTextView {
        withId(R.id.theme_chooser_reading_focus_mode_description)
    }

    val themeTitle = KTextView {
        containsText("Theme")
    }

    val lightThemeButton = KTextView {
        withId(R.id.button_theme_light)
    }

    val sepiaThemeButton = KTextView {
        withId(R.id.button_theme_sepia)
    }

    val darkThemeButton = KTextView {
        withId(R.id.button_theme_dark)
    }

    val blackThemeButton = KTextView {
        withId(R.id.button_theme_black)
    }

    val matchSystemThemeSwitch = KCheckBox {
        withId(R.id.theme_chooser_match_system_theme_switch)
    }

    val darkModeDimImagesSwitch = KCheckBox {
        withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    }
}