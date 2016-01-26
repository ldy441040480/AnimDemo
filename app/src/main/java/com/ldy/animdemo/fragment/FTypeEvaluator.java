package com.ldy.animdemo.fragment;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ldy.animdemo.AnimFragment;
import com.nineoldandroids.animation.TypeEvaluator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;

/**
 * TypeEvaluator<T> :
 * interface 计算类型值 支持泛型
 *
 * 方法：
 * T evaluate(float fraction, T startValue, T endValue)
 * 就是用来计算属性值的，即可计算任意类型的值。
 *
 * fraction:
 * 表示时间的比率。
 *
 * 实现类有：
 * ArgbEvaluator ARGB颜色计算器
 * FloatEvaluator float型计算器
 * IntEvaluator int计算器
 *
 * Created by ldy on 2015/11/24.
 */
public class FTypeEvaluator extends AnimFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView.setText("*");
        mView.setTextColor(Color.BLUE);
        ViewHelper.setTranslationY(mView, 200);
        ViewHelper.setTranslationX(mView, 0);
    }

    @Override
    protected void onAnimStart(final View view) {
        ValueAnimator animator = ValueAnimator.ofObject(new ValueTypeEvaluator(), new PointF(0, 0));
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF p = (PointF) animation.getAnimatedValue();
                view.setTranslationX(p.x);
                view.setTranslationY(p.y);
            }
        });
    }

    static class ValueTypeEvaluator implements TypeEvaluator<PointF> {

        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            PointF p = new PointF();
            p.x =  400f * fraction * 2f;           // x = v * t
            p.y =  150f * (float) Math.sin(1f / 25f * p.x) + 200;    // y = a * cos(w * x) + b
            return p;
        }
    }

    @Override
    protected String getTitle() {
        return "TypeEvaluator";
    }
}
