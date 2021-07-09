package ru.mstrike.popit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.View
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
    val popitDesktop by lazy {
        PopitDesktop(this).apply {
//            val d = resources.getDrawable(R.drawable.ic_desk3)
//            gameViewModel.desktopBackground = d
            bindViewModel(gameViewModel)
//            var parser = assets.openXmlResourceParser("game1.xml")
            var parser = assets.open("game1.xml")
            loadGame("game1.xml")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        rootView = findViewById(R.id.root)
        popitDesktop.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT)
        rootView.addView(popitDesktop)
    }
}