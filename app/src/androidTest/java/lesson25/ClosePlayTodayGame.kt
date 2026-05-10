package lesson25

import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import io.qameta.allure.kotlin.Allure

class ClosePlayTodayGame(testContext: BaseTestContext) : ScreenBehaviorBase(testContext) {

    override val step = "Закрывает блок запуска игры"
    override val action: Allure.StepContext.() -> Unit = {
        getElementById("closeButton").click()
    }

    override fun isConditionMet(): Boolean {
        return checkScreenById("playGameButton")
    }
}