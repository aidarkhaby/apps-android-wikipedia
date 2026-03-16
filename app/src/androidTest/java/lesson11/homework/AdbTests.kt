package lesson11.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import lesson08.homework.ExploreScreen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson03.homeworks.OnboardingScreen
import org.wikipedia.main.MainActivity
import java.util.Locale.ENGLISH
import java.util.Locale.FRENCH

class AdbTests : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOrientation() {
        run("Поворот экрана и проверка ориентации") {
            device.uiDevice.setOrientationLandscape()
            Thread.sleep(3000)
            device.uiDevice.setOrientationPortrait()
            Thread.sleep(3000)
            device.uiDevice.isNaturalOrientation
        }
    }

/*
    @Test
    fun checkSwitchOffScreen() {
        run("Выключение экрана, включение и проверка отображения элемента (любого)") {
            device.uiDevice.sleep()
            device.uiDevice.wakeUp()
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

 */

    @Test
    fun checkCollapseDisplay() {
        run("Свернуть приложение кнопкой home и развернуть дважды нажав recent apps и проверить отображение элемента (любого)") {
            device.uiDevice.pressHome()
            repeat(2) {
                device.uiDevice.pressRecentApps()
                Thread.sleep(500)
            }
            OnboardingScreen.skipButton.isDisplayed()
        }
    }

    @Test
    fun checkNetwork() {
        before("Выключить сеть, перейти в статью и проверить отображение ошибки и кнопки Retry. " +
                "Включить сеть и нажать Retry, проверить отображение заголовка (может работать некорректно, в этом случае забить на тест)") {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi disable")
        }.run {

        }
    }

    @Test
    fun checkLanguageChangeAndCheckButtonText() {
        before("Поменять язык приложения и проверить текст какой-нибудь кнопки (не через ресурсы)") {
            device.language.switchInApp(FRENCH)
        }.after {
            device.language.switchInApp(ENGLISH)
        }.run {
            OnboardingScreen.skipButton {
                isDisplayed()
                hasText("Sauter")
            }
        }
    }

    @Test
    fun checkMainActivity() {
        run("Проверить, что сейчас активна MainActivity.") {
            OnboardingScreen.skipButton.click()
            device.activities.isCurrent(MainActivity::class.java)
        }
    }
}