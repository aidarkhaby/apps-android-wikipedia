package lesson18.extensions

import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem

// Расширение для KViewPager2
inline fun <reified T : KViewPagerItem<T>> KViewPager2.invokeByIndex(index: Int, fnc: T.() -> Unit) {
    val pager = this
    childAt<T>(index) {
        name(pager.withParent("$index"))
        fnc()
    }
}