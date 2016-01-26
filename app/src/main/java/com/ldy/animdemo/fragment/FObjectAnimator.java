package com.ldy.animdemo.fragment;

import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.ldy.animdemo.AnimFragment;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

/**
 *
 * className:
 *      ObjectAnimator   ValueAnimator
 *
 * propertyName:
 *      alpha   scaleX   scaleY   pivotX   pivotY
 *      rotation   rotationX   rotationY
 *      translationX   translationY ...
 *
 * 方法:
 *      ofFloat   ofInt   ofObject   ofPropertyValuesHolder
 *      setStartDelay   setRepeatMode   setRepeatCount   setInterpolator   setDuration
 *      addListener   addUpdateListener
 *      start   cancel   end   reverse ...
 *
 * Created by ldy on 2015/11/22.
 */
public class FObjectAnimator extends AnimFragment {

    private ObjectAnimator mAnimator;

    @Override
    public void onAnimStart(View view) {
        if (mAnimator == null)
            mAnimator = getRotationAnim(view);

        if (!mAnimator.isStarted()) {
            mAnimator.start();
        } else if (mAnimator.isRunning()) {
            mAnimator.cancel();    // 调用 onAnimationCancel -->onAnimationEnd
//            mAnimator.end();  // 调用 onAnimationEnd
        }
    }

    @Override
    public void onAnimReset(View view) {
        if (mAnimator == null)
            mAnimator = getRotationAnim(view);

        if (mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        reset(mView);
    }

    @Override
    protected String getTitle() {
        return "ObjectAnimator";
    }

    private ObjectAnimator getRotationAnim(View view) {
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(view, "rotationX", 0.0f, 360.0f);
        rotationX.setRepeatMode(ValueAnimator.RESTART);
        rotationX.setRepeatCount(ValueAnimator.INFINITE);
        rotationX.setInterpolator(new LinearInterpolator());
        rotationX.setDuration(1000);
        rotationX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.i("Animator", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i("Animator", "onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i("Animator", "onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i("Animator", "onAnimationRepeat");
            }
        });
        return rotationX;
    }
}
