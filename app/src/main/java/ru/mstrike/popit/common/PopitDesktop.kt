наверное package ru.mstrike.popit.common

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.toDrawable
import androidx.core.widget.ImageViewCompat
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.FileInputStream

/**
 * Базовый класс для все игровых досок
 */
class PopitDesktop(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : ConstraintLayout(context, attrs, defStyleAttr) {

    /**
     * Игровая матрица в которой хранятся состояния ячеек
     */
    var gameMatrix: Array<Array<Int>> = emptyArray()

    private var viewModel: GameViewModel? = null

    /**
     * Матрица с элементами управления, отображаемыми на экране.
     * Размер матрицы и картинки элементов должны соответствовать размеру
     * и состояниям ячеек матрицы [gameMatrix]
     */
    var viewsMatrix: Array<Array<ImageView>> = emptyArray()

    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)

    constructor(context: Context): this(context, null)

    init {
        initGameMatrix(4, 4)
    }

    /**
     * Метод для привязки ViewModel к классу.
     * Это что бы картинки не перезагружать при смене конфигурации
     */
    fun bindViewModel(viewModel: GameViewModel) {
        this.viewModel = viewModel
        background = viewModel.desktopBackground
    }

    /**
     * Метод инициализирует и заполняет 0 игровую матрицу [gameMatrix]
     * @param rows кол-во создаваемых строк в матрице
     * @param columns кол-во создаваемых колонок в матрице
     */
    private fun initGameMatrix(rows: Int, columns: Int) {
        gameMatrix = Array(rows) { Array(columns) { 1 } }
        viewsMatrix = Array(rows) { Array(columns) { ImageView(context) } }
    }

    /**
     * Метод загружает из каталога assets указанную игру в файле xml
     */
    fun loadGame(xmlFileName: String) {
        XmlPullParserFactory.newInstance().apply {
//            var parser = context.assets.openXmlResourceParser("1.svg")
            var parser = context.assets.openXmlResourceParser("$xmlFileName")
            while (parser.eventType == XmlPullParser.START_TAG && parser.name == "game") {

            }
            parser.next()
        }
    }

}