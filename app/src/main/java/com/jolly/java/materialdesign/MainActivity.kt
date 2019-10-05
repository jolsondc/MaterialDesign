package com.jolly.java.materialdesign

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.drawable.Animatable
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.jolly.java.materialdesign.utils.TransitionListener
import android.util.Pair as UtilPair


class MainActivity : AppCompatActivity() {
    var relativeLayout : RelativeLayout?=null
    var mainLayout:ConstraintLayout?=null
    var textview:TextView?=null
    var imageView:ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        relativeLayout =findViewById(R.id.relativeLayout)
        mainLayout =findViewById(R.id.mainLayout)
        imageView = findViewById(R.id.imageView)
        textview = findViewById(R.id.textview)

        imageView!!.setOnClickListener(object: View.OnClickListener{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(v: View?) {
                startAnimatedActivity()
            }

        })

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun performClick(view: View){
        animateChildren()
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun animateChildren(){
        val slide1= Slide()
        slide1.duration = 1000
        slide1.slideEdge=Gravity.TOP
        slide1.addTarget(relativeLayout)

        val fade = Fade()
        fade.duration=2000
        fade.addTarget(imageView)

        val fade2 = Fade()
        fade2.duration = 2000
        fade2.addTarget(textview)


        fade2.addListener(object :TransitionListener(){
            override fun onTransitionEnded() {
                val animatable = (imageView as ImageView).drawable as Animatable
                animatable.start()
            }

        })


        val set = TransitionSet()
        set.addTransition(slide1)
        set.addTransition(fade)
        set.addTransition(fade2)

        TransitionManager.beginDelayedTransition(mainLayout, set)
        relativeLayout!!.visibility = View.VISIBLE
        imageView?.visibility=View.VISIBLE
        textview!!.visibility=View.VISIBLE

    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun startAnimatedActivity(){

        val intent = Intent(this, SecondActivity::class.java)
        val pair1 = UtilPair.create<View,String>(imageView, "imageMain")
        val pair2 = UtilPair.create<View,String>(textview, "textMain")
        val options = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity,
            pair1,
            pair2)
        startActivity(intent, options.toBundle())
    }
}
