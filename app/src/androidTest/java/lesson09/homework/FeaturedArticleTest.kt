package lesson09.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import lesson08.homework.CustomizeItem
import lesson08.homework.CustomizeRecycler
import lesson08.homework.CustomizeScreen
import lesson08.homework.ExploreScreen
import lesson08.homework.FeaturedArticleItem
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson03.homeworks.OnboardingScreen
import org.wikipedia.main.MainActivity


class FeaturedArticleTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun hideFeaturedArticleTest() {
        run("Проверка функционала скрытия блока Featured Article") {
            step("Нажимает Skip на экране онбординга") {
                OnboardingScreen.skipButton.click()
            }
            ExploreScreen.items {
                childWith<FeaturedArticleItem> {
                    isInstanceOf(FeaturedArticleCardView::class.java)
                } perform {
                    step("Проверяет отображение блока Featured Article экрана Explore") {
                        isDisplayed()
                    }
                }
            }
                ExploreScreen.items {
                    childWith<CustomizeItem> {
                        IsInstanceOf(AnnouncementCardView::class.java)
                    } perform {
                        step("Нажимает на кнопку Customize в блоке Customize your Explore feed экрана Explore"){
                            customizeButton.click()
                        }
                    }
                }
            CustomizeScreen{
                items.childWith<CustomizeRecycler> {
                    withDescendant { withText("Featured article") }
                } perform {
                    step("Отключает тогл Featured article"){
                        checkbox.click()
                        checkbox.isNotChecked()
                    }
                }
                step("Нажимает стрелку назад в тулбаре"){
                    backButton.click()
                }
            }
            ExploreScreen{
                step("Проверяет, что отображается экран Explore"){
                    logo.isDisplayed()
                    items {
                        childWith<FeaturedArticleItem> {
                           isInstanceOf(FeaturedArticleCardView::class.java)
                        } perform {
                            step("Проверяет, что блок Featured Article не отображается на экране Explore") {
                                headerText.doesNotExist()
                            }
                        }
                    }
                }
            }
        }
    }
}