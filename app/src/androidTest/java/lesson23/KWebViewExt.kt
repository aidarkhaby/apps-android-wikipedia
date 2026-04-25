package lesson23

import io.github.kakaocup.kakao.web.KWebView
import lesson23.ArticleScreen.webView

fun KWebView.withXpath(xPath: String) : KWebViewElement {
    return KWebViewElement(
        webView = this,
        xPath
    )
}