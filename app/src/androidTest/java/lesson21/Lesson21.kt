package lesson21

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import lesson18.extensions.getName
import lesson18.extensions.name
import lesson18.extensions.withParent
import org.hamcrest.Matcher
import kotlin.math.min

class HasIdOrChildWithIdAction(private val resourceId: Int) : ViewAction {

    private var result = false

    override fun getDescription() = "Check that view contains view with specified resource id"

    override fun getConstraints(): Matcher<View> = ViewMatchers.isAssignableFrom(View::class.java)

    override fun perform(uiController: UiController?, view: View?) {
        if (view == null) throw IllegalStateException("View not submitted")
        if (view.id == resourceId) {
            result = true
        } else {
            val foundView = view.findViewById<View>(resourceId)
            result = foundView != null
        }
    }

    fun getResult() = result
}

class HasClassOrChildWithClass(private val expectedClass: Class<out View>) : ViewAction {

    private var result = false

    override fun getDescription() = "Check that view has class or contains view with class"

    override fun getConstraints(): Matcher<View> = ViewMatchers.isAssignableFrom(View::class.java)

    override fun perform(uiController: UiController?, view: View?) {
        result = view?.let {
            checkInnerViewsClassContains(it, expectedClass)
        } ?: throw IllegalStateException("View not submitted")
    }

    private fun checkInnerViewsClassContains(view: View, expectedClass: Class<out View>): Boolean {
        if (expectedClass.isAssignableFrom(view::class.java)) return true
        if (view is ViewGroup) {
            view.children.forEach {
                if (checkInnerViewsClassContains(it, expectedClass)) return true
            }
        }
        return false
    }

    fun getResult() = result
}

fun BaseActions.hasIdOrChildWithId(resourceId: Int): Boolean {
    val hasIdOrChildWithIdIdAction = HasIdOrChildWithIdAction(resourceId)
    view.perform(hasIdOrChildWithIdIdAction)
    return hasIdOrChildWithIdIdAction.getResult()
}

fun BaseActions.hasClassOrChildWithClass(clazz: Class<out View>): Boolean {
    val hasClassOrChildWithClass = HasClassOrChildWithClass(clazz)
    view.perform(hasClassOrChildWithClass)
    return hasClassOrChildWithClass.getResult()
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndClass(
    index: Int,
    limit: Int,
    startWith: Int,
    clazz: Class<out View>,
    blockName: String = "$index",
    fnc: T.() -> Unit
) {
    val numberOfElements = this.getSize()
    val lastIndex = min(numberOfElements - 1, limit)
    val firstIndex = min(startWith, lastIndex)
    var counter = 0
    val recycler = this
    for (i in firstIndex..lastIndex){
        childAt<T>(i){
            val isElementWithClass = hasClassOrChildWithClass(clazz)
            if (isElementWithClass && counter++ == index){
                name(recycler.getName().withParent(blockName))
                fnc()
                return
            }
        }
    }
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndId(
    index: Int,
    id: Int,
    limit: Int = 20,
    startWith: Int,
    blockName: String = "$index",
    fnc: T.() -> Unit
) {
    val numberOfElements = this.getSize()
    var isElementFoundByIndex = false
    val lastIndex = min(numberOfElements - 1, limit)
    val firstIndex = min(startWith, lastIndex)
    var counter = 0
    val recycler = this
    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementWithId = hasIdOrChildWithId(id)
            if (isElementWithId && index == counter++) {
                isElementFoundByIndex = true
                name(recycler.getName().withParent(blockName))
                fnc()
            }
        }
        if (isElementFoundByIndex) break
    }
        if (!isElementFoundByIndex) {
            throw IllegalStateException("Элемент с индексом $index в пределах ${lastIndex + 1} элементов не найден")
        }
    }