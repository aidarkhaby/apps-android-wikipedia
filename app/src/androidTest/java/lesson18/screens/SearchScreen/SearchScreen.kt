package lesson18.screens.SearchScreen

import io.github.kakaocup.kakao.common.views.KView
import lesson18.extensions.name
import lesson18.utils.NamedScreen
import lesson22.NoRecentlyViewedWidget
import lesson22.SearchWidget
import org.wikipedia.R
import org.wikipedia.views.CabSearchView

object SearchScreen : NamedScreen<SearchScreen>() {
    override val screenName: String = "Экран Search"
    override val layoutId = null
    override val viewClass = null

    val searchField = KView() {
        isInstanceOf(CabSearchView::class.java)
        withId(R.id.search_cab_view)
    }.name(withParent("Поле Search Wikipedia"))

    val searchWidget by lazy {
        SearchWidget{
            withId(R.id.search_card)
        }.name(withParent("Виджет поиска"))
    }

    val noRecentlyViewedWidget by lazy {
        NoRecentlyViewedWidget {
            withId(R.id.history_empty_container)
        }.name(withParent("Виджет пустой Истории"))
    }
}