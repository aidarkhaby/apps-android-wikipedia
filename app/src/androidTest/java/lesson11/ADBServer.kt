package lesson11

import android.view.Surface
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Test

class ADBServer : TestCase() {

    @Test
    fun preAndPostScenario() {
        before("Название теста") {
            device.network.toggleMobileData(false)
            device.network.toggleWiFi(false)
        }.after {
            device.network.toggleMobileData(true)
            device.network.toggleWiFi(true)
        }.run {
            // код сценария
        }
    }

    @Test
    fun checkAdb(){
        run{
            device.uiDevice.setOrientationRight()
            Thread.sleep(3000)
            val act = device.uiDevice.getDisplayRotation()
            val ex = Surface.ROTATION_270
            Assert.assertEquals(ex, act)
        }
    }
}