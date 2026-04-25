package lesson23

import io.github.kakaocup.kakao.web.KWebView


abstract class KWebViewItem(
    kWebView: KWebView,
    listContainerXpath: String
) : KWebViewElementBase<KWebViewItem>(kWebView, listContainerXpath)