package lesson24.screen

import androidx.appcompat.widget.AppCompatImageButton
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import lesson18.extensions.name
import lesson18.utils.NamedScreen
import org.wikipedia.R

object YourLanguagesScreen : NamedScreen<YourLanguagesScreen>(){
    override val screenName: String = "Экран Your languages"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val addLanguage by lazy {
        KTextView {
            withText("Add language")
        }.name(withParent("Кнопка Add language"))
    }

    val backToolbarButton by lazy {
        KButton {
            withParent {
                withId(R.id.toolbar)
            }
            isInstanceOf(AppCompatImageButton::class.java)
        }.name(withParent("Кнопка назад в тулбаре"))
    }
}