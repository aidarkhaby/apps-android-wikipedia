package lesson18.screens.SettingsScreen

import io.github.kakaocup.kakao.recycler.KRecyclerView
import lesson18.extensions.name
import lesson18.utils.NamedScreen
import org.wikipedia.R


object SettingsScreen : NamedScreen<SettingsScreen>() {
    override val screenName: String = "Экран настроек"
    override val layoutId = null
    override val viewClass = null

    val items by lazy {
        KRecyclerView(
            builder = { withId(R.id.recycler_view) },
            itemTypeBuilder = {
                itemType(::SettingsItem)
            }
        ).name(withParent("Список блоков"))
    }
}