package ru.mstrike.popit.models

import androidx.core.widget.ImageViewCompat

/**
 * Модель для описания состояния и содержимого одной ячейки игровой матрицы
 */
data class DesktopCellModel(
    /**
     * Состояние ячейки.
     */
    var state: CellStates,

    /**
     * Компонент для отрисовки текущего состояния ячейки
     */
    var ivCell: ImageViewCompat? = null
) {
    /**
     * Класс, описывающий состояние ячейки
     */
    enum class CellStates(i: Int) {
        /**
         * Пустая ячейка, не участвует в игре
         */
        EMPTY(0),

        /**
         * Ячейка закрыта, под ней нет бомбы
         */
        CLOSED(1),

        /**
         * Ячейка закрыта, под ней бомба
         */
        CLOSED_WITH_BOMB(2),

        /**
         * Ячейка открыта пользователем, в ней нет бомбы
         */
        OPEN(3),

        /**
         * Бомба, открыта
         */
        BOMB(4)
    }

}