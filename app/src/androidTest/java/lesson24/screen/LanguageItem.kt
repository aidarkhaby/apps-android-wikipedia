package lesson24.screen

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import lesson24.name
import lesson24.withParent
import org.wikipedia.compose.uitest.Tags.CANONICAL_LANGUAGE_NAME
import org.wikipedia.compose.uitest.Tags.LOCALIZED_LANGUAGE_NAME

class LanguageItem(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? = null
) : KLazyListItemNode<LanguageItem>(semanticNode, semanticsProvider) {

    val localName by lazy {
        child<KNode> {
            hasTestTag(LOCALIZED_LANGUAGE_NAME)
        }.name(withParent("Locale name"))
    }

    val canonicName by lazy {
        child<KNode> {
            hasTestTag(CANONICAL_LANGUAGE_NAME)
        }.name(withParent("Canonic name"))
    }
}