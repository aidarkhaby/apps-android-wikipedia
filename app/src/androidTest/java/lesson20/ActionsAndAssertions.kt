package lesson20

import android.view.View
import android.widget.Checkable
import android.widget.EditText
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.kaspersky.kaspresso.device.permissions.Permissions
import io.github.kakaocup.kakao.common.views.KBaseView
import lesson18.screens.explore.ExploreScreen
import lesson18.screens.onboarding.OnboardingScreen
import org.hamcrest.Matcher
import org.junit.Test

class MultiAction(private val enableText: String) : ViewAction {

    override fun getConstraints(): Matcher<View?>? {
        return ViewMatchers.isDisplayed()
    }

    override fun getDescription(): String? {
        return "Toggle on toggleable or type 'On' in text input"
    }

    override fun perform(
        uiController: UiController?,
        view: View?
    ) {
        if (view == null) return
        when (view) {
            is Permissions.Button -> view.performClick()
            is Checkable -> view.isChecked = true
            is EditText -> ViewActions.typeText(enableText).perform(uiController, view)
        }
    }
}

fun KBaseView<*>.multiAction() {
    view.perform(MultiAction("On"))
}

class TestClass {

    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
        }
    }
}