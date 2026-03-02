package lesson08.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R


class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {

    val header = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val icon = KImageView(matcher) {
        withId(R.id.view_list_card_item_image)
    }

    val menuIcon = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val items = KRecyclerView(
        parent = matcher,
        builder = { withId(R.id.view_list_card_list) },
        itemTypeBuilder = {
            itemType(::TopReadRecycler)
        }
    )

    val moreLink = KTextView(matcher){
        withId(R.id.footerActionButton)
    }
}