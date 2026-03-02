package lesson08.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class DayItem(matcher: Matcher<View>) : KRecyclerItem<DayItem>(matcher) {

    val text = KTextView(matcher){
        withId(R.id.day_header_text)
    }

}