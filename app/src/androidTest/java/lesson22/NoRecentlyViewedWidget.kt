package lesson22

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import lesson18.extensions.name
import lesson18.extensions.withParent
import org.wikipedia.R


class NoRecentlyViewedWidget(builder: ViewBuilder.() -> Unit) :
    KWidget<NoRecentlyViewedWidget>(builder) {

    val image = {
            KImageView(matcher) {
                withId(R.id.history_empty_image)
            }.name(withParent("Картинка"))
        }

    val title = {
            KTextView(matcher) {
                withId(R.id.history_empty_image)
            }.name(withParent("Заголовок"))
        }

    val text = {
            KTextView(matcher) {
                withId(R.id.history_empty_image)
            }.name(withParent("Текст"))
        }
}