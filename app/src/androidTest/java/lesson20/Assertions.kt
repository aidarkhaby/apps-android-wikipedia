package lesson20

import android.view.View
import android.widget.TextView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import io.github.kakaocup.kakao.text.TextViewAssertions
import lesson18.screens.onboarding.OnboardingScreen
import org.junit.Assert
import org.junit.Test

class EqualsWithTrimAssertion(private val expected: String) : ViewAssertion {

    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (view == null) {
            throw (noViewFoundException ?: IllegalStateException("No view found"))
        }
        val actual = (view as? TextView)?.text
            ?.trim()
            ?.toString()
        if (actual == null) {
            throw IllegalStateException("It is not text view")
        }
        Assert.assertEquals(expected, actual)
    }
}

fun TextViewAssertions.equalsWithTrim(expected: String) {
    view.check(EqualsWithTrimAssertion(expected))
}

class AssertionTest {
    @Test
    fun assertionTest() {
        run {
            OnboardingScreen.page(1) {
                title.equalsWithTrim("New ways to explore")
            }
        }
    }
}