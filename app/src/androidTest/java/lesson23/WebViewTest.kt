package lesson23

import lesson18.screens.explore.ExploreScreen
import lesson18.screens.explore.ExploreScreen.items
import lesson18.screens.explore.TopReadItem
import lesson18.screens.onboarding.OnboardingScreen
import lesson18.utils.BaseTest
import lesson19.ext.action
import lesson19.ext.verify
import org.junit.Test

class WebViewTest: BaseTest(){

    @Test
    fun titleWebViewTest(){
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                items.childAt<TopReadItem>(0, {
                    action.click(this)
                    Thread.sleep(3000)
                })
            }
            verify.isDisplayed(ArticleScreen.title)
        }
    }

    @Test
    fun indexReferenceWebViewTest(){
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                cardListItem(0) {
                    action {
                        click(image)
                    }
                }
            }
            ArticleScreen{
                Thread.sleep(2000)
                action.clickOnWebView(references)
                Thread.sleep(2000)
                referenceItem(2){
                    verify.hasText(
                        index,
                        "[2]"
                    )
                }
            }
        }
    }
}