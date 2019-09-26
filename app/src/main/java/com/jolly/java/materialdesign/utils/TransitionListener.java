package com.jolly.java.materialdesign.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.transition.Transition;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public abstract class TransitionListener implements Transition.TransitionListener {
    @Override
    public void onTransitionStart(Transition transition) {

    }

    @Override
    public void onTransitionEnd(Transition transition) {
        onTransitionEnded();
    }

    @Override
    public void onTransitionCancel(Transition transition) {

    }

    @Override
    public void onTransitionPause(Transition transition) {

    }

    @Override
    public void onTransitionResume(Transition transition) {

    }

    public abstract void onTransitionEnded();
}
