package lesson26

import android.util.Log
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

class HomeworkInterceptor : TestRunWatcherInterceptor {

    override fun onTestStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "Test started")
    }

    override fun onBeforeSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "Before section started")
    }
    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "Before section finished success")
    }
    override fun onBeforeSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        Log.i("KASPRESSO", "Before section finished failed")
    }

    override fun onMainSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "Main section started")
    }
    override fun onMainSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "Main section finished success")
    }
    override fun onMainSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        Log.i("KASPRESSO", "Main section finished failed")
    }

    override fun onAfterSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "After section started")
    }
    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "After section finished success")
    }
    override fun onAfterSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        Log.i("KASPRESSO", "After section finished failed")
    }

    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        Log.i("KASPRESSO", "Finished test")
    }
}