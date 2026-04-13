package lesson18.screens.explore

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import lesson18.extensions.name
import lesson18.extensions.withParent
import org.hamcrest.Matcher
import org.wikipedia.R


class TopReadRecycler(matcher: Matcher<View>) : KRecyclerItem<TopReadRecycler>(matcher) {

    val header by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.name(withParent("Заголовок"))
    }

    val subtitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }.name(withParent("Подзаголовок"))
    }

    val graph by lazy {
        KView(matcher) {
            withId(R.id.view_list_card_item_graph)
        }.name(withParent("Граф"))
    }

    val pageviews by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_pageviews)
        }.name(withParent("Page views"))
    }

    val numberView by lazy {
        KTextView(matcher) {
            withId(R.id.numberView)
        }.name(withParent("numberView"))
    }

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.name(withParent("Картинка"))
    }

}
