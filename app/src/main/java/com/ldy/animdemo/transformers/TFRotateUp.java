package com.ldy.animdemo.transformers;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class TFRotateUp extends TFBasePage {

	private static final float ROT_MOD = -15f;

	@Override
	public void onTransform(View view, float position) {
		final float width = view.getWidth();
		final float rotation = ROT_MOD * position;

		ViewHelper.setPivotX(view,width * 0.5f);
		ViewHelper.setPivotY(view, 0f);
		ViewHelper.setTranslationX(view, 0f);
		ViewHelper.setRotation(view,rotation);
	}
}