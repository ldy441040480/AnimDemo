package com.ldy.animdemo.transformers;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class TFRotateDown extends TFBasePage {

	private static final float ROT_MOD = -15f;

	@Override
	public void onTransform(View view, float position) {
		final float width = view.getWidth();
		final float height = view.getHeight();
		final float rotation = ROT_MOD * position * -1.25f;

		ViewHelper.setPivotX(view,width * 0.5f);
		ViewHelper.setPivotY(view,height);
		ViewHelper.setRotation(view, rotation);
	}
}
