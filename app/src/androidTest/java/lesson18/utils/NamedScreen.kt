package lesson18.utils

import com.kaspersky.kaspresso.screens.KScreen
import lesson18.utils.NameHierarchy

abstract class NamedScreen <T : NamedScreen<T>> : KScreen<T>() {

    abstract val screenName: String

    private val nameHierarchy by lazy {
        NameHierarchy(screenName)
    }

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }
}