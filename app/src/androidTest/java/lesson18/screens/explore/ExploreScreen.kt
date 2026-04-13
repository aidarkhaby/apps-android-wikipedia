package lesson18.screens.explore

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import lesson08.homework.CustomizeItem
import lesson08.homework.DayItem
import lesson08.homework.FeaturedArticleItem
import lesson08.homework.NewsItem
import lesson08.homework.SearchItem
import lesson08.homework.TopReadItem
import lesson18.extensions.invokeWithText
import lesson18.extensions.name
import lesson18.utils.NamedScreen
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object ExploreScreen : NamedScreen<ExploreScreen>() {
    override val screenName: String = "Экран Explore"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val logo by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }.name(withParent("Иконка лого"))
    }

    val retryButton by lazy {
        KButton {
            withId(R.id.view_card_offline_button_retry)
        }.name(withParent("Кнопка Retry"))
    }

    val closeButton by lazy {
        KButton {
            withId(R.id.closeButton)
        }.name(withParent("Кнопка Close"))
    }


    val items by lazy {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = {
                itemType(::SearchItem)
                itemType(::CustomizeItem)
                itemType(::DayItem)
                itemType(::TopReadItem)
                itemType(::NewsItem)
                itemType(::FeaturedArticleItem)
            }
        ).name(withParent("Список блоков"))
    }

    fun customizeBlock(fnc: CustomizeItem.() -> Unit) {
        items.invokeWithText("Customize", fnc)
    }
}