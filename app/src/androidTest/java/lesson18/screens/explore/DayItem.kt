package lesson18.screens.explore

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import lesson18.extensions.name
import lesson18.extensions.withParent
import org.hamcrest.Matcher
import org.wikipedia.R

class DayItem(matcher: Matcher<View>) : KRecyclerItem<DayItem>(matcher) {

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.day_header_text)
        }.name(withParent("Заголовок"))
    }

}