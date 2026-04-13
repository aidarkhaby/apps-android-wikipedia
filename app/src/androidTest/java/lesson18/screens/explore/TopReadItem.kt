package lesson18.screens.explore

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import lesson08.homework.TopReadRecycler
import lesson18.extensions.name
import lesson18.extensions.withParent
import org.hamcrest.Matcher
import org.wikipedia.R


class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {

    val header by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }

    val icon by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.name(withParent("Иконка"))
    }

    val menuIcon by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Иконка меню"))
    }

    val items by lazy {
        KRecyclerView(
            parent = matcher,
            builder = { withId(R.id.view_list_card_list) },
            itemTypeBuilder = {
                itemType(::TopReadRecycler)
            }
        ).name(withParent("Список статей"))
    }

    val moreLink by lazy {
        KTextView(matcher) {
            withId(R.id.footerActionButton)
        }.name(withParent("Кнопка more link"))
    }
}