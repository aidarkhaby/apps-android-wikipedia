package lesson24.screen

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import lesson18.extensions.name
import lesson18.utils.NamedScreen

object YourLanguagesScreen : NamedScreen<YourLanguagesScreen>(){
    override val screenName: String = "Экран Your languages"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val addLanguage by lazy {
        KTextView {
            withText("Add language")
        }.name(withParent("Кнопка Add language"))
    }
}