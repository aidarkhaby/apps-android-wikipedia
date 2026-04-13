package lesson18.screens.explore

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import lesson18.extensions.name
import lesson18.extensions.withParent
import org.hamcrest.Matcher
import org.wikipedia.R

class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {

    val icon by lazy {
        KImageView(matcher) {
            withIndex(0) {
                isInstanceOf(AppCompatImageView::class.java)
            }
        }.name(withParent("Иконка поиска"))
    }

    val text by lazy {
        KTextView(matcher) {
            isInstanceOf(MaterialTextView::class.java)
            withText("Search Wikipedia")
        }.name(withParent("Текст"))
    }

    val voiceIcon by lazy {
        KImageView(matcher) {
            withId(R.id.voice_search_button)
        }.name(withParent("Иконка микрофона"))
    }
}