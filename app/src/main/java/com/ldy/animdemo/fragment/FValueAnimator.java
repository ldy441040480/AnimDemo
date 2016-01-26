package com.ldy.animdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.ldy.animdemo.AnimFragment;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by ldy on 2015/11/22.
 */
public class FValueAnimator extends AnimFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewHelper.setRotationX(mView, 45f);
        ViewHelper.setRotationY(mView, 30f);
        ViewHelper.setX(mView, 100);
        ViewHelper.setY(mView, 100);
    }

    @Override
    protected void onAnimStart(final View view) {

        ValueAnimator anim = ValueAnimator.ofFloat(0.25f, 1f);
        anim.setDuration(2000);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                view.setAlpha(cVal);
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }

    @Override
    protected void onAnimReset(View view) {}

    @Override
    protected String getTitle() {
        return "ValueAnimator";
    }
}
