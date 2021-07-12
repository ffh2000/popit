package ru.mstrike.popit.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * Модель, описывающая вид и расположение элементов игровой доски
 */
@Keep
class PopitDesktopModel {
    /**
     * Имя drawable для фона из ресурсов
     */
    @SerializedName("background-res")
    val backgroundResourceName: String? = null


}