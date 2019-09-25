package com.jolly.java.materialdesign

import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout


class MainActivity : AppCompatActivity() {
    var relativeLayout : RelativeLayout?=null
    var mainLayout:ConstraintLayout?=null
    var height:Int=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        relativeLayout =findViewById(R.id.relativeLayout)
        mainLayout =findViewById(R.id.mainLayout)
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
         height = size.y
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun performClick(view: View){
        val transition = Slide()
        transition.duration = 1000
        transition.slideEdge=Gravity.TOP
        TransitionManager.beginDelayedTransition(mainLayout, transition)
        relativeLayout!!.visibility = View.VISIBLE
       /* relativeLayout!!.animate().setDuration(2000).translationY(height.toFloat())
            .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                           // view.visibility = View.GONE
                      }
                   })*/
    }
}
