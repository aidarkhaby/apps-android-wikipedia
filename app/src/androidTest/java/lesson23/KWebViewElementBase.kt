package lesson23

import androidx.test.espresso.web.webdriver.Locator
import io.github.kakaocup.kakao.web.KWebView
import io.github.kakaocup.kakao.web.WebElementBuilder
import lesson18.utils.NameHierarchy


abstract class KWebViewElementBase<T : KWebViewElementBase<T>>(
    val webView: KWebView,
    val xpath: String
) {

    abstract val self: T

    private var nameHierarchy = NameHierarchy("NO_LABEL")

    fun name(nameHierarchy: NameHierarchy): T {
        this.nameHierarchy = nameHierarchy
        return self
    }

    fun getName(): NameHierarchy {
        return nameHierarchy
    }

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }

    fun perform(function: T.() -> Unit) {
        function(self)
    }

    inline fun <reified T : KWebViewElementBase<T>> child(xpath: String): T {
        return T::class.java
            .getConstructor(KWebView::class.java, String::class.java)
            .newInstance(webView, "${this.xpath}$xpath")
    }

    fun child(xpath: String): KWebViewElement {
        return KWebViewElement::class.java
            .getConstructor(KWebView::class.java, String::class.java)
            .newInstance(webView, "${this.xpath}$xpath")
    }

    inline fun <reified T : KWebViewElementBase<T>> child(xpath: String, position: Int): T {
        return T::class.java
            .getConstructor(KWebView::class.java, String::class.java)
            .newInstance(webView, "(${this.xpath}$xpath)[$position]")
    }

    operator fun invoke(function: T.() -> Unit) {
        function(self)
    }

    fun performWebViewAction(function: WebElementBuilder.KWebInteraction.() -> Unit) {
        webView {
            withElement(
                Locator.XPATH,
                xpath,
                function
            )
        }
    }
}