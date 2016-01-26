package com.ldy.animdemo.fragment;

import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.ldy.animdemo.AnimFragment;
import com.nineoldandroids.view.ViewPropertyAnimator;

/**
 * ViewPropertyAnimator
 *
 *
 * Interpolator:
 *      interface 插值器 控制动画的变化速率
 *
 *      getInterpolation  结果值0到1之间
 *
 *      BounceInterpolator   AccelerateDecelerateInterpolator
 *      DecelerateInterpolator   LinearInterpolator
 *      AccelerateInterpolator ...
 *
 * Created by ldy on 2015/11/22.
 */
public class FViewPropertyAnimator extends AnimFragment {

    @Override
    protected void onAnimStart(View view) {
        super.onAnimStart(view);
        ViewPropertyAnimator animate = ViewPropertyAnimator.animate(view);
        animate.cancel();
        animate.alpha(0f).scaleX(0.2f).scaleY(0.5f).setDuration(300).setInterpolator(new MyInterpolator()).start();
    }

    @Override
    protected void onAnimReset(View view) {
        ViewPropertyAnimator animate = ViewPropertyAnimator.animate(view);
        animate.cancel();
        animate.alpha(1f).scaleX(1f).scaleY(1f).setDuration(300).setInterpolator(new MyInterpolator()).start();
    }

    @Override
    protected String getTitle() {
        return "ViewPropertyAnimator";
    }

    static class MyInterpolator extends AccelerateInterpolator {

        @Override
        public float getInterpolation(float input) {
            return (float) Math.pow(input, 3.0);
        }
    }
}
