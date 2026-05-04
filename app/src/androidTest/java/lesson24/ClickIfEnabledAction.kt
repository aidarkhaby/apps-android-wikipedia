package lesson24

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.performClick
import io.github.kakaocup.compose.intercept.operation.ComposeAction

class ClickIfEnabledAction : ComposeAction {

    override val type = CustomOperationTypes.CUSTOM_CLICK_ACTION
    override val description = "Click only if element is enabled"

    override fun execute(innerView: SemanticsNodeInteraction) {
        val isDisabled = innerView.fetchSemanticsNode()
            .config
            .contains(SemanticsProperties.Disabled)
        if (!isDisabled) {
            innerView.performClick()
        }
    }
}