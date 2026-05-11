package lesson26

import android.util.Log
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor

class BeforeAfterBehaviorInterceptor : ViewBehaviorInterceptor {
    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        Log.i("KASPRESSO", "BEFORE ACTION")
        Log.i("KASPRESSO", "AFTER ACTION")
        throw AssertionError()
    }
}