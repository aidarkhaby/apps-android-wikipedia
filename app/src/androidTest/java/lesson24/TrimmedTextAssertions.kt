package lesson24

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.SemanticsNodeInteraction
import io.github.kakaocup.compose.intercept.operation.ComposeAssertion
import org.junit.Assert

class TrimmedTextAssertions(private val expectedText: String) : ComposeAssertion {

    override val type = CustomOperationTypes.TRIMMED_TEXT_ASSERTION
    override val description = "Node text must be equals with '$expectedText'"

    override fun execute(innerView: SemanticsNodeInteraction) {
        val text = innerView.fetchSemanticsNode()
            .config
            .getOrNull(SemanticsProperties.Text) ?: emptyList()
        val editableText = innerView.fetchSemanticsNode()
            .config.getOrNull(SemanticsProperties.EditableText)
        val expected = expectedText.trim()
        val actual = (text + editableText).filterNotNull()
        Assert.assertTrue(
            "Ожидаемое значение: '$expectedText', получено: ${actual}",
            actual.any { it.text.trim() == expected }
        )
    }
}