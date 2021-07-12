package ru.mstrike.popit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.View
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import ru.mstrike.popit.common.GameViewModel
import ru.mstrike.popit.common.PopitDesktop.PopitDesktop
import ru.mstrike.popit.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    lateinit var rootView: ConstraintLayout
    private lateinit var binding: ActivityGameBinding

    /**
     * ViewModel для хранения игровых данных.
     * Инициализруется лениво.
     * Доступ к свойству возможен после отраотки onAttached т.е. когда Activity
     * существует
     */
    val gameViewModel by viewModels<GameViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        rootView = binding.root
        setContentView(rootView)
        binding.pdDesktop.apply {
            bindViewModel(gameViewModel)
            loadGame("game1.json")
        }
    }
}