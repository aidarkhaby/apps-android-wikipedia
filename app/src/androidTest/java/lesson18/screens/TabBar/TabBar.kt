package lesson18.screens.TabBar

import io.github.kakaocup.kakao.tabs.KTabLayout
import lesson18.extensions.name
import lesson18.utils.NamedScreen
import org.wikipedia.R

object TabBar : NamedScreen<TabBar>() {
    override val screenName: String = "Табы"
    override val layoutId = null
    override val viewClass = null

    val exploreTab by lazy {
        KTabLayout {
            withId(R.id.nav_tab_explore)
        }.name(withParent("Таб Explore"))
    }

    val savedTab by lazy {
        KTabLayout {
            withId(R.id.nav_tab_reading_lists)
        }.name(withParent("Таб Saved"))
    }

    val searchTab by lazy {
        KTabLayout {
            withId(R.id.nav_tab_search)
        }.name(withParent("Таб Search"))
    }

    val activityTab by lazy {
        KTabLayout {
            withId(R.id.nav_tab_edits)
        }.name(withParent("Таб Activity"))
    }

    val moreTab by lazy {
        KTabLayout {
            withId(R.id.nav_tab_more)
        }.name(withParent("Таб More"))
    }

}