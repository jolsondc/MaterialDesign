package com.jolly.java.materialdesign.utils;

import android.animation.Animator;

public abstract class AnimatorListener implements Animator.AnimatorListener{
    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    @Override
    public void onAnimationStart(Animator animation, boolean isReverse) {

    }

    @Override
    public void onAnimationEnd(Animator animation, boolean isReverse) {
        onAnimationEnd();
    }
   public abstract void onAnimationEnd();
}
