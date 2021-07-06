package ru.mstrike.popit.common

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel

/**
 * ViewModel для хранения состояния игры
 */
class GameViewModel: ViewModel() {
    /**
     * Изображение фона игровой доски
     */
    var desktopBackground: Drawable? = null

    /**
     * Изображение бомбы
     */
    var bomb: Bitmap? = null

    /**
     * Изображение открытой ячейки
     */
    var openedCell: Bitmap? = null
}