package lesson22

import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import lesson18.extensions.name
import lesson18.extensions.withParent
import org.wikipedia.R

class SearchWidget(builder: ViewBuilder.() -> Unit) : KWidget<SearchWidget>(builder) {
    val searchIcon by lazy {
        KImageView(matcher) {
            withContentDescription("Search Wikipedia")
        }.name(withParent("Иконка поиска"))
    }

    val searchText by lazy {
        KTextView(matcher) {
            isInstanceOf(MaterialTextView::class.java)
        }.name(withParent("Текст поиска"))
    }

    val voiceIcon by lazy {
        KImageView(matcher) {
            withId(R.id.voice_search_button)
        }.name(withParent("Иконка голоса"))
    }
}