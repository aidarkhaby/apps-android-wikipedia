package lesson19.ext

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import lesson19.Actions
import lesson19.StepDefinitions
import lesson19.StepsDsl
import lesson19.Verify

private val steps = mutableMapOf<String, StepsDsl<*>>()

val TestContext<*>.action: Actions
    get() {
        return steps[getId(this, "action")] as? Actions
            ?: Actions(StepDefinitions(this)).also{
                steps[getId(this, "action")] = it
            }
    }

val TestContext<*>.verify: Verify
    get() {
        return steps[getId(this, "verify")] as? Verify
            ?: Verify(StepDefinitions(this)).also {
                steps[getId(this, "verify")] = it
            }
    }

private fun getId(testContext: TestContext<*>, stepType: String): String {
    return "${testContext.hashCode()}-$stepType"
}