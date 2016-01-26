package com.ldy.animdemo.transformers;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by lidongyang on 2015/11/16.
 */
public abstract class TFBasePage implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View view, float position) {
        ViewHelper.setRotation(view, 0);
        ViewHelper.setScaleX(view, 1);
        ViewHelper.setScaleY(view, 1);
        ViewHelper.setPivotX(view, 0);
        ViewHelper.setPivotY(view, 0);
        ViewHelper.setTranslationY(view, 0);
        ViewHelper.setTranslationX(view, 0);
        ViewHelper.setAlpha(view, 1f);

        onTransform(view, position);
    }

    protected abstract void onTransform(View view, float position);
}
