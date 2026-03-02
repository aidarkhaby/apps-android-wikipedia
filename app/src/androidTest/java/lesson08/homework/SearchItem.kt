package lesson08.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {

    val icon = KImageView(matcher) {
        withIndex(0){
            isInstanceOf(AppCompatImageView::class.java)
        }
    }

    val text = KTextView(matcher){
        isInstanceOf(MaterialTextView::class.java)
        withText("Search Wikipedia")
    }

    val voiceIcon = KImageView(matcher) {
        withId(R.id.voice_search_button)
    }
}