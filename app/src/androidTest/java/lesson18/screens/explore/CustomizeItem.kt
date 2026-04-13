package lesson18.screens.explore

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import lesson18.extensions.name
import lesson18.extensions.withParent
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeItem>(matcher) {

    val image by lazy {
        KImageView(matcher) {
            isInstanceOf(AppCompatImageView::class.java)
        }.name(withParent("Картинка"))
    }

    val text by lazy {
        KTextView(matcher) {
            withId(R.id.view_announcement_text)
        }.name(withParent("Текст"))
    }

    val customizeButton by lazy {
        KButton {
            withId(R.id.view_announcement_action_positive)
        }.name(withParent("Кнопка Customize"))
    }

    val gotItButton by lazy {
        KButton {
            withId(R.id.view_announcement_action_negative)
        }.name(withParent("Кнопка Got it"))
    }
}