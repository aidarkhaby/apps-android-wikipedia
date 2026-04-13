package lesson18.extensions

import io.github.kakaocup.kakao.common.actions.BaseActions
import lesson18.utils.NameHierarchy

private val elements = mutableMapOf<BaseActions, NameHierarchy>()

fun <T : BaseActions> T.name(nameHierarchy: NameHierarchy): T {
    elements[this] = nameHierarchy
    return this
}

fun <T : BaseActions> T.getName(): NameHierarchy {
    return elements[this] ?: NameHierarchy("NO_LABEL", null)
}

fun <T : BaseActions> T.withParent(name: String): NameHierarchy {
    return getName().withParent(name)
}