import ru.mstrike.popit.common.GameViewModel

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import org.xmlpull.v1.XmlPullParser
import com.google.gson.Gson
import ru.mstrike.popit.models.PopitDesktopModel

/**
 * Базовый класс для все игровых досок
 */
class PopitDesktop(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

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

    /**
     * Конфигурация, загруженная из файла
     */
    var configuration: PopitDesktopModel? = null

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): this(context, attrs, defStyleAttr, 0)

    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0, 0)

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
     * Метод открывает из папки assest xml-файл и возвращает на ссылку на парсер для работы с ним
     * [XmlPullParser]
     */
    private fun assetsOpenJson(fileName: String) {
        val fv = context.assets.open("$fileName").reader()
        configuration = Gson().fromJson(fv, PopitDesktopModel::class.java)
    }

    /**
     * Метод загружает из каталога assets указанную игру в файле xml
     */
    fun loadGame(fileName: String) {
        assetsOpenJson(fileName)
        configuration?.let { configuration ->
            val res = resources.getIdentifier(configuration.backgroundResourceName, "drawable", context.packageName)
            background = resources.getDrawable(res)
        }
    }

    /**
     * Метод перекрыт что бы поддерживать пропорции размеров поизображению из [background]
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (background != null) {
            var w = MeasureSpec.getSize(widthMeasureSpec) - 100
            var h = MeasureSpec.getSize(heightMeasureSpec) - 100
            setMeasuredDimension(w, h)
        } else {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
        }
    }
}