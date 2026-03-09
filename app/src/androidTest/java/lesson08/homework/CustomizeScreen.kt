package lesson08.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.android.material.appbar.MaterialToolbar
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.feed.configure.ConfigureItemView
import org.wikipedia.R
import org.hamcrest.Matcher


object CustomizeScreen : KScreen<CustomizeScreen>() {
    override val layoutId = R.layout.item_feed_content_type
    override val viewClass = ConfigureItemView::class.java

    val backButton = KImageView {
        withParent {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }

    val items = KRecyclerView(
        builder = { withId(org.wikipedia.R.id.content_types_recycler) },
        itemTypeBuilder = {
            itemType(::CustomizeRecycler)
        }
    )

}