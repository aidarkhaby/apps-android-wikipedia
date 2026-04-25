package lesson22

import android.view.View
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.common.views.KBaseView
import org.hamcrest.Matcher

open class KWidget<T> : KBaseView<T>, BaseActions, BaseAssertions {

    val matcher: Matcher<View>

    constructor(builder: ViewBuilder.() -> Unit) : super(builder) {
        matcher = ViewBuilder().apply(builder).getViewMatcher()
    }

    constructor(parent: Matcher<View>, builder: ViewBuilder.() -> Unit) : this(
        {
            builder(this)
            isDescendantOfA { withMatcher(parent) }
        }
    )
}
