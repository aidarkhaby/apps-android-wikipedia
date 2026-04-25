package lesson23

import io.github.kakaocup.kakao.web.KWebView
import lesson18.utils.NamedScreen
import org.wikipedia.R

object ArticleScreen : NamedScreen<ArticleScreen>() {
    override val screenName: String = "Экран статьи"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    /*
    val title by lazy {
        KWebViewElement (
            webView,
            "//h1"
        ).name(withParent("Заголовок"))
    }

     */

    val title by lazy {
        webView.withXpath("//h1")
            .name(withParent("Заголовок"))
    }

    val references by lazy {
        webView.withXpath("//*[@id=\"References\"]")
            .name(withParent("Блок References"))
    }

    val referencesList by lazy {
        KWebViewList(webView, "//ol")
            .name(withParent("Список"))
    }

    fun referenceItem(index: Int, fnc: ReferencesItem.() -> Unit) {
        referencesList.childAt(index, fnc)
    }
}