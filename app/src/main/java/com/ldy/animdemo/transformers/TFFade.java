package com.ldy.animdemo.transformers;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class TFFade extends TFBasePage {

    @Override
    public void onTransform(View page, float position) {
        // Page is not an immediate sibling, just make transparent
        if(position < -1 || position > 1) {
            ViewHelper.setAlpha(page, 0.6f);
        }
        // Page is sibling to left or right
        else if (position <= 0 || position <= 1) {

            // Calculate alpha.  Position is decimal in [-1,0] or [0,1]
            float alpha = (position <= 0) ? position + 1 : 1 - position;
            ViewHelper.setAlpha(page, alpha);

        }
        // Page is active, make fully visible
        else if (position == 0) {
            ViewHelper.setAlpha(page, 1);
        }
    }
}