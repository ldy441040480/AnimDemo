package com.ldy.animdemo.transformers;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class TFAccordion extends TFBasePage {

    @Override
    public void onTransform(View page, float position) {
        ViewHelper.setTranslationX(page, -page.getWidth() * position);
        ViewHelper.setPivotX(page, position < 0 ? 0 : page.getWidth());
        ViewHelper.setScaleX(page, position < 0 ? 1f + position : 1f - position);
    }
}