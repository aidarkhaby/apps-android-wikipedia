package lesson13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.web.KWebView
import lesson08.homework.ExploreScreen
import lesson08.homework.SearchItem
import lesson08.homework.TopReadItem
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.lesson03.homeworks.OnboardingScreen
import org.wikipedia.main.MainActivity

object ArticleScreen : KScreen<ArticleScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView = KWebView() {
        withId(R.id.page_web_view)
    }
}

class WebViewTests : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
            step("Нажимает Skip на экране онбординга") {
                OnboardingScreen.skipButton.click()
            }

            step("Кликает по поиску") {
                ExploreScreen.items {
                    childWith<SearchItem> {
                        withDescendant { withContentDescription("Search Wikipedia") }
                    } perform {
                        text.click()
                    }
                }
            }

            step("Вводит в поиске pulp fiction"){
                //device.uiDevice.findObject(UiSelector().id)
            }
        }

    }
}