package lesson25

class PassInterferingScreens(private val screenBehaviors: List<ScreenBehaviorBase>) {

    /**
     * Вернёт true если мешающий экран был обнаружен и обработан
     */
    fun execute(): Boolean {
        return screenBehaviors.any { it.initBehavior() }
    }
}