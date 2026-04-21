package lesson18.screens.MoreBottomSheet

import androidx.compose.ui.test.hasText
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KTextView
import lesson18.extensions.name
import lesson18.utils.NamedScreen
import org.wikipedia.R

object MoreBottomSheet : NamedScreen<MoreBottomSheet>() {
    override val screenName: String = "Боттомшит More"
    override val layoutId = null
    override val viewClass = null

    val logIn by lazy {
        KTextView {
            withId(R.id.main_drawer_login_button)
        }.name(withParent("Текст Log in"))
    }

    val places by lazy {
        KTextView {
            withText("Places")
        }.name(withParent("Текст Places"))
    }

    val settings by lazy {
        KTextView {
            withText("Settings")
        }.name(withParent("Текст Settings"))
    }

    val donate by lazy {
        KTextView {
            withText("Donate")
        }.name(withParent("Текст Donate"))
    }

}