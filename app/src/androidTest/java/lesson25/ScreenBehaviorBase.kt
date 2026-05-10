package lesson25

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import io.qameta.allure.kotlin.Allure

private const val WAIT = 50L

abstract class ScreenBehaviorBase(protected val testContext: BaseTestContext) {

    val appPackage: String = testContext.device.targetContext.packageName
    abstract val step: String
    abstract val action: Allure.StepContext.() -> Unit

    abstract fun isConditionMet(): Boolean

    fun initBehavior(): Boolean {
        val isConditionMet = isConditionMet()
        if (isConditionMet) {
            executeStep(action)
        }
        return isConditionMet
    }

    fun initBehaviorRepeatedly(tries: Int): Boolean {
        var counter = tries
        while (counter-- > 0) {
            if (initBehavior()) return true
            Thread.sleep(1000)
        }
        return false
    }

    protected fun getElementById(id: String): UiObject {
        return testContext.device
            .uiDevice
            .findObject(
                UiSelector().resourceId(
                    "$appPackage:id/$id"
                )
            )
    }

    protected fun getElementByText(text: String): UiObject {
        return testContext.device
            .uiDevice
            .findObject(
                UiSelector().text(text)
                )
    }

    protected fun checkScreenById(id: String): Boolean {
        return getElementById(id).waitForExists(WAIT)
    }

    protected fun checkScreenByText(text: String): Boolean {
        return getElementByText(text).waitForExists(WAIT)
    }

    protected fun <T> executeStep(block: Allure.StepContext.() -> T) {
        testContext.testLogger.i("Behavior '$step' was executed")
        Allure.step(step, block)
    }
}