package lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R


class NewsRecycler(matcher: Matcher<View>) : KRecyclerItem<NewsRecycler>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }

    val header = KTextView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }
}
