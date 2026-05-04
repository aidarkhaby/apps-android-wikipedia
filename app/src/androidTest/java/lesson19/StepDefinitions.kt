package lesson19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import lesson23.KWebViewElement
import lesson24.assertTrimmedTextIsEquals
import lesson24.clickIfEnabled

class StepDefinitions(private val testContext: TestContext<*>) {

    fun click(step: String, element: BaseActions) {
        execute(step) {
            element.click()
        }
    }

    fun isDisplayed(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisplayed()
        }
    }

    fun hasText(step: String, element: TextViewAssertions, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.containsText(text)
            } else {
                element.hasText(text)
            }
        }
    }

    fun doesNotExist(step: String, element: BaseAssertions) {
        execute(step) {
            element.doesNotExist()
        }
    }

    private fun execute(step: String, fnc: () -> Unit) {
        testContext.step(step) {
            fnc()
        }
    }

    fun isDisplayed(step: String, element: KWebViewElement){
        execute(step){
            element.performWebViewAction { scroll() }
        }
    }

    fun clickOnWebView(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction {  click() }
        }
    }

    fun hasTextWebView(step: String, element: KWebViewElement, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.performWebViewAction {  containsText(text) }
            } else {
                element.performWebViewAction {  hasText(text) }
            }
        }
    }

    fun clickIfEnabled(step: String, element: NodeActions) {
        execute(step) {
            element.clickIfEnabled()
        }
    }

    fun assertTrimmedTextIsEquals(step: String, element: NodeAssertions, expected: String) {
        execute(step) {
            element.assertTrimmedTextIsEquals(expected)
        }
    }
}