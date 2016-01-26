package com.ldy.animdemo.fragment;

import android.view.View;
import android.view.animation.BounceInterpolator;

import com.ldy.animdemo.AnimFragment;
import com.nineoldandroids.animation.Keyframe;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;

/**
 * PropertyValuesHolder:
 *      属性值持有者  持有属性名、开始与结束值。
 *
 *      属性设置方法：
 *      setIntValues()、setFloatValues()、setObjectValues()、setKeyframes setEvaluator(eval);
 *
 *      静态of方法:
 *      ofInt、ofFloat、ofObject、ofKeyframe
 *
 *
 * Keyframe:
 *      含有 时间比率和帧值 属性
 *
 *      方法:
 *      ofInt、ofFloat、ofObject
 *
 * KeyframeSet:
 *      就是一组 KeyFrame
 *
 *      方法: ofInt、ofFloat、ofObject、ofKeyframe
 *
 * Created by ldy on 2015/11/24.
 */
public class FPropertyValueHolder extends AnimFragment {

    @Override
    protected void onAnimStart(View view) {

        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("alpha", 0, 1);
        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("scaleX", 0.1f, 0.475f, 1);
        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("scaleY", 0.1f, 0.475f, 1);
//        PropertyValuesHolder p4 = PropertyValuesHolder.ofFloat("translationY", 200, -60, 0);

        Keyframe kf0 = Keyframe.ofFloat(0f, 200f);
        Keyframe kf1 = Keyframe.ofFloat(0.5f, -40f);
        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
        PropertyValuesHolder p4 = PropertyValuesHolder.ofKeyframe("translationY", kf0, kf1, kf2);

        Keyframe kf10 = Keyframe.ofInt(0, 400);
        Keyframe kf11 = Keyframe.ofInt(0.25f, 200);
        Keyframe kf12 = Keyframe.ofInt(0.5f, 400);
        Keyframe kf13 = Keyframe.ofInt(0.75f, 100);
        Keyframe kf14 = Keyframe.ofInt(1f, 400);
        PropertyValuesHolder p5 = PropertyValuesHolder.ofKeyframe("width", kf10, kf11, kf12, kf13, kf14);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mView, p1, p2, p3, p4);

        objectAnimator.setDuration(1500);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.start();
    }

    @Override
    protected String getTitle() {
        return "ObjectAnimator PropertyValuesHolder";
    }
}
