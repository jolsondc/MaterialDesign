package com.jolly.java.materialdesign

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageView
import android.transition.Fade
import android.transition.TransitionManager
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.jolly.java.materialdesign.utils.AnimatorListener
import com.jolly.java.materialdesign.utils.TransitionListener


class SecondActivity :AppCompatActivity() {

    var relativeLayout:RelativeLayout? = null
    var mainLayout: ConstraintLayout?=null
    var textview: TextView?=null
    var imageView: AppCompatImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        mainLayout =findViewById(R.id.mainLayout)
        relativeLayout = findViewById(R.id.relativeLayout)
        imageView = findViewById(R.id.imageView)
        textview = findViewById(R.id.textview)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.sharedElementEnterTransition.addListener(object : TransitionListener() {
                override fun onTransitionEnded() {
                        startAnimation()
                    }
            })
        }
    }

    fun startAnimation(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val fade =   Fade()
        fade.duration=2000
        fade.addTarget(relativeLayout)

            TransitionManager.beginDelayedTransition(mainLayout, fade)
            relativeLayout!!.visibility = View.GONE
        } else {
            relativeLayout!!.visibility = View.GONE
        }
        val colorAnim = ObjectAnimator.ofInt(
            textview, "textColor",
            Color.WHITE, Color.BLACK
        )
        colorAnim.duration=2000
        colorAnim.addListener(object : AnimatorListener(){
            override fun onAnimationEnd() {
                imageView!!.setColorFilter(ContextCompat.getColor(this@SecondActivity, android.R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY)
            }
        })
        colorAnim.setEvaluator(ArgbEvaluator())
        colorAnim.start()

    }

}