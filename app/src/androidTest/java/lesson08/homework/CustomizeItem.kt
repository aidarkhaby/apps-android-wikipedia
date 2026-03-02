package lesson08.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeItem>(matcher) {

    val image = KImageView(matcher) {
            isInstanceOf(AppCompatImageView::class.java)
    }

    val text = KTextView(matcher){
        withId(R.id.view_announcement_text)
    }

    val customizeButton = KButton{
        withId(R.id.view_announcement_action_positive)
    }

    val gotItButton = KButton{
        withId(R.id.view_announcement_action_negative)
    }
}