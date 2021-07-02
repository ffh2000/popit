package ru.mstrike.popit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.view.View
import kotlinx.coroutines.*
import ru.mstrike.popit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /**
     * Обработчик клика при выборе вида игровой доски
     */
    private val gameDeskSelectListener = { _: View ->
        binding.incGameOptions.vfGameOptions.showNext()
    }

    /**
     * Обработчик при нажатии кнопок для старта игры
     */
    private val gameStartListener = { _: View ->
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(R.anim.flip_in, R.anim.flip_out)
    }


    private fun startAnimations() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.bg_animation)
        binding.bground.startAnimation(anim)
        binding.incStart.ivStart.startAnimation(AnimationUtils.loadAnimation(this, R.anim.start_button))
    }

    private fun setupListeners() {
        //нажатие кнопки "Старт"
        binding.incStart.ivStart.setOnClickListener {
            binding.vfMainMenu.showNext()
        }
        binding.incGameOptions.incOption1.ivDesk1.setOnClickListener(gameDeskSelectListener)
        binding.incGameOptions.incOption1.ivDesk2.setOnClickListener(gameDeskSelectListener)
        binding.incGameOptions.incOption1.ivDesk3.setOnClickListener(gameDeskSelectListener)
        binding.incGameOptions.incOption1.ivDesk4.setOnClickListener(gameDeskSelectListener)
        binding.incGameOptions.incOption2.selectLeve1.setOnClickListener(gameStartListener)
        binding.incGameOptions.incOption2.selectLeve2.setOnClickListener(gameStartListener)
        binding.incGameOptions.incOption2.selectLeve2.setOnClickListener(gameStartListener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GlobalScope.launch(Dispatchers.IO) {
            startAnimations()
            setupListeners()
        }
    }
}
