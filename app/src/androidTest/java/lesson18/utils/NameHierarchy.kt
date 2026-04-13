package lesson18.utils

class NameHierarchy(private val name: String, private val parent: NameHierarchy? = null) {

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, this)
    }

    override fun toString(): String {
        return (parent?.let { "$it : " } ?: "") + name
    }
}