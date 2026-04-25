package lesson23

import io.github.kakaocup.kakao.web.KWebView

class KWebViewList(
    webView: KWebView,
    listContainerXpath: String
) : KWebViewElementBase<KWebViewList>(webView, listContainerXpath) {

    override val self = this

    inline fun <reified T : KWebViewItem> childAt(position: Int, function: T.() -> Unit) {
        val element = T::class.java
            .getConstructor(KWebView::class.java, String::class.java)
            .newInstance(webView, "$xpath/*[$position]")
            .name(withParent("$position"))
        element.performWebViewAction { scroll() }
        function(element as T)
    }
}