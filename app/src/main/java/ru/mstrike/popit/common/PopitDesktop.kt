package ru.mstrike.popit.common

import android.content.Context
import android.util.AttributeSet
import android.view.*
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * Базовый класс для все игровых досок
 */
class PopitDesktop(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : ConstraintLayout(context, attrs, defStyleAttr) {

    /**
     * Игровая матрица в которой хранятся состояния ячеек
     */
    var gameMatrix: Array<Array<Int>> = arrayOf()

    /**
     * Матрица с элементами управления, отображаемыми на экране.
     * Размер матрицы и картинки элементов должны соответствовать размеру
     * и состояниям ячеек матрицы [gameMatrix]
     */
    var viewsMatrix: Array<Array<View?>> = arrayOf()

    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)

    constructor(context: Context): this(context, null)

    init {
        initGameMatrix(4, 4)
    }

    /**
     * Метод инициализирует и заполняет 0 игровую матрицу [gameMatrix]
     * @param rows кол-во создаваемых строк в матрице
     * @param columns кол-во создаваемых колонок в матрице
     */
    fun initGameMatrix(rows: Int, columns: Int) {
        gameMatrix = arrayOf()
        viewsMatrix = arrayOf()
        for (i in 0 until rows) {
            val a = arrayOf<Int>()
            val v = arrayOf<View?>()
            for (j in 0 until columns) {
                a[j] += 0
                v[j] = null
            }
            gameMatrix += a
            viewsMatrix += v
        }
    }

}