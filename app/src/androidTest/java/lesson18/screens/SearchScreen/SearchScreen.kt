package lesson18.screens.SearchScreen

import io.github.kakaocup.kakao.common.views.KView
import lesson18.extensions.name
import lesson18.utils.NamedScreen
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


}