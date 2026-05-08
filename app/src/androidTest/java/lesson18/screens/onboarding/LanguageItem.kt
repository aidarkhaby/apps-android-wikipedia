package lesson18.screens.onboarding

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.TextViewAssertions
import lesson18.screens.onboarding.PagerItem
import org.hamcrest.Matcher

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<LanguageItem>(matcher), TextViewAssertions