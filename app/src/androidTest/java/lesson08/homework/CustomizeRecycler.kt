package lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeRecycler(matcher: Matcher<View>) : KRecyclerItem<CustomizeRecycler>(matcher) {

    val header = KTextView(matcher) {
        withId(R.id.feed_content_type_title)
    }

    val subtitle = KTextView(matcher) {
        withId(R.id.feed_content_type_subtitle)
    }

    val image = KImageView(matcher) {
        withId(R.id.feed_content_type_drag_handle)
    }

    val checkbox = KCheckBox(matcher) {
        withId(R.id.feed_content_type_checkbox)
    }
}