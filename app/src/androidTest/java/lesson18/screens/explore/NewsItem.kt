package lesson18.screens.explore

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import lesson08.homework.NewsRecycler
import lesson18.extensions.name
import lesson18.extensions.withParent
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsItem(matcher: Matcher<View>) : KRecyclerItem<NewsItem>(matcher) {

    val header by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }

    val icon by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Иконка"))
    }

    val items by lazy {
        KRecyclerView(
            parent = matcher,
            builder = { withId(R.id.view_list_card_list) },
            itemTypeBuilder = {
                itemType(::NewsRecycler)
            }
        ).name(withParent("Список статей"))
    }
}