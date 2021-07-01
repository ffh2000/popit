package ru.mstrike.popit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.SurfaceControl
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.view.animation.AnticipateInterpolator
import android.view.animation.Interpolator
import android.widget.ImageView
import androidx.constraintlayout.solver.state.State
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.start_layout.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val anim = AnimationUtils.loadAnimation(this, R.anim.bg_animation)
        bground.startAnimation(anim)
        startPicture.startAnimation(AnimationUtils.loadAnimation(this, R.anim.start_button))

//        startHand.startAnimation(AnimationUtils.loadAnimation(this, R.anim.hand_animation))
//        startHand

//        val constraintSet = ConstraintSet()
//        constraintSet.clone(this, R.layout.start_layout_animation)
//        val transition = ChangeBounds()
////        transition.setInterpolator(AccelerateDecelerateInterpolator())
//        transition.setInterpolator(AnticipateInterpolator(1.0f))
//        transition.setDuration(2000)
//        TransitionManager.beginDelayedTransition(clStart, transition)
//        constraintSet.applyTo(clStart)
    }
}