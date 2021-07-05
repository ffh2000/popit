package ru.mstrike.popit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.View
import ru.mstrike.popit.common.GameViewModel
import ru.mstrike.popit.common.PopitDesktop

class GameActivity : AppCompatActivity() {

    lateinit var rootView: ConstraintLayout

    /**
     * ViewModel для хранения игровых данных.
     * Инициализруется лениво.
     * Доступ к свойству возможен после отраотки onAttached т.е. когда Activity
     * существует
     */
    val gameViewModel by viewModels<GameViewModel>()

    /**
     * Игровая доска
     */
    val popitDesktop by lazy { PopitDesktop(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        rootView = findViewById(R.id.root)
        popitDesktop.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT)
        popitDesktop.bindViewModel(gameViewModel)
        rootView.addView(popitDesktop)
    }
}