package lesson27

import android.util.Log
import io.qameta.allure.kotlin.AllureId
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class ExampleRule : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        Log.i("KASPRESSO", "Before TEST RULE STARTED")
        Log.i("KASPRESSO", description?.displayName ?: "")
        /*
        val annot = description?.getAnnotation<AllureId>(AllureId::class.java)
            ?.value
        if (annot !in Config.testCases){
            throw IllegalStateException("Неподходящий тест кейс")
        }
        Log.i("KASPRESSO", annot ?: "")
         */
        return object : Statement() {
            override fun evaluate() {
                val annot = description?.getAnnotation<AllureId>(AllureId::class.java)
                    ?.value
                if (annot !in Config.testCases) {
                    throw IllegalStateException("Неподходящий тест кейс")
                }
                try {
                    base?.evaluate()
                } catch (e: Throwable) {
                    Log.i("KASPRESSO", e.message ?: "Empty message")
                }
                Log.i("KASPRESSO", "AFTER TEST RULE STARTED")
            }
        }
       // return MyStatement(base)
    }
}

object Config {
    val testCases = listOf("1", "2", "3")
}

class SampleTest() {

    @get:Rule
    val baseRule = ExampleRule()

    @Test
    @AllureId("4")
    fun testTest() {
        Log.i("KASPRESSO", "Log testTest")
        Assert.assertTrue("Тут упали", false)
    }
}

/*
class MyStatement(
    val base: Statement?,
    val description: Description
) : Statement() {
    override fun evaluate() {
        val annot = description?.getAnnotation<AllureId>(AllureId::class.java)
            ?.value
        if (annot !in Config.testCases){
            throw IllegalStateException("Неподходящий тест кейс")
        }
        try {
            base?.evaluate()
        } catch (e: Throwable) {
            Log.i("KASPRESSO", e.message ?: "Empty message")
        }
        Log.i("KASPRESSO", "AFTER TEST RULE STARTED")
    }
 */

