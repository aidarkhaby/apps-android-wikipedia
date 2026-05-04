package lesson19

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.text.KTextView
import lesson18.extensions.getName
import lesson23.KWebViewElement
import lesson24.getName

class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun clickOnWebView(element: KWebViewElement) {
        steps.clickOnWebView("Нажимает на '${(element).getName()}'", element)
    }

    fun clickIfEnabled(element: NodeActions) {
        steps.clickIfEnabled("Click if enabled '${element.getName()}'", element)

    }
}