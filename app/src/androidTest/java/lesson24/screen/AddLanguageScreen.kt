package lesson24.screen

import lesson24.ComposeNamedScreen
import lesson24.createLazyList
import org.wikipedia.compose.uitest.Tags.LANGUAGE_LIST

object AddLanguageScreen : ComposeNamedScreen<AddLanguageScreen>() {
    override val screenName: String = "Add Language Screen"

    val items by lazy {
        createLazyList(
            viewBuilderAction = {
                hasTestTag(LANGUAGE_LIST)
            },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            }
        )
    }
}
