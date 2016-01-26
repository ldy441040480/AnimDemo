package com.ldy.animdemo.transformers;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class TFStack extends TFBasePage {

	@Override
	public void onTransform(View view, float position) {
		ViewHelper.setTranslationX(view, position < 0 ? 0f : -view.getWidth() * position);
		ViewHelper.setPivotX(view, position < 0 ? 0 : view.getWidth());
		ViewHelper.setScaleX(view, position < 0 ? 1f + position : 1f - position);
	}
}
