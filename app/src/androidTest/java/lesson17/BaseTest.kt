package lesson17

import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase

open class BaseTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()){

}