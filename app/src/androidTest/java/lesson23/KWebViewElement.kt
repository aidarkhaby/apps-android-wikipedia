package lesson23

import io.github.kakaocup.kakao.web.KWebView

class KWebViewElement(
    webView: KWebView,
    xpath: String
) : KWebViewElementBase<KWebViewElement>(webView, xpath) {

    override val self = this
}