package com.ldy.animdemo.fragment;

import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.ldy.animdemo.AnimFragment;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by ldy on 2015/11/22.
 */
public class FAnimatorSet extends AnimFragment {

    @Override
    protected void onAnimStart(View view) {

        float x = (view.getWidth() - view.getPaddingLeft() - view.getPaddingRight())/2
                + view.getPaddingLeft();
        float y = view.getHeight() - view.getPaddingBottom();

        ViewHelper.setPivotX(view, x);
        ViewHelper.setPivotY(view, y);

        ObjectAnimator rotationY = ObjectAnimator.ofFloat(view, "rotationX", 55, -30, 10, -5, 0).setDuration(2000);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 0.2f, 1.0f).setDuration(2000);
        ObjectAnimator colorAnim = ObjectAnimator.ofInt(view, "textColor", 0xffFF8080, 0xff80ff80);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setDuration(2000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateInterpolator());

//        animatorSet.play(rotationY).with(alpha);
//        animatorSet.play(rotationY).after(alpha);
//        animatorSet.play(rotationY).before(alpha);
//        animatorSet.playSequentially(rotationY, alpha); //分步执行
        animatorSet.playTogether(rotationY, alpha, colorAnim);
        animatorSet.start();



//        --------------------- xml ---------------------------
//        Animator animator = AnimatorInflater.loadAnimator(getActivity(), R.animator.object_animator);
//        Animator animator = AnimatorInflater.loadAnimator(getActivity(), R.animator.animator);
//        animator.setTarget(view);
//        animator.start();
    }

    @Override
    protected String getTitle() {
        return "AnimatorSet";
    }
}
