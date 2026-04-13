package lesson18.extensions

import androidx.test.espresso.matcher.ViewMatchers
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.hamcrest.Matchers.anyOf

// Расширения для KRecyclerView
inline fun <reified T : KRecyclerItem<T>> KRecyclerView.getByIndex(index: Int): T {
    return childWith<T> {
        onPosition(index)
    }.name(withParent("$index"))
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.getByText(text: String): T {
    return childWith<T> {
        withMatcher(
            anyOf(
                ViewMatchers.withText(text),
                ViewMatchers.hasDescendant(ViewMatchers.withText(text))
            )
        )
    }.name(withParent(text))
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndex(index: Int, fnc: T.() -> Unit) {
    getByIndex<T>(index).fnc()
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeWithText(text: String, fnc: T.() -> Unit) {
    getByText<T>(text).fnc()
}