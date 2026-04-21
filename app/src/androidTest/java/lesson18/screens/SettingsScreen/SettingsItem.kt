package lesson18.screens.SettingsScreen

import android.view.View
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R


class SettingsItem(matcher: Matcher<View>) : KRecyclerItem<SettingsItem>(matcher) {

    val title = KTextView(matcher){
        isInstanceOf(MaterialTextView::class.java)
    }

    val subtitle = KTextView(matcher) {
        isInstanceOf(MaterialTextView::class.java)
    }

    val switcher = KCheckBox(matcher) {
        withId(R.id.switchWidget)
    }
}