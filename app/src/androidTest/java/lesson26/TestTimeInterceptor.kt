package lesson26

import android.util.Log
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor

class TestTimeInterceptor : ViewBehaviorInterceptor {
    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        val beforeTime = System.nanoTime()
        val result = action()
        val afterTime = System.nanoTime()
        Log.i("KASPRESSO", "Time: ${afterTime - beforeTime}")
        return result
    }
}