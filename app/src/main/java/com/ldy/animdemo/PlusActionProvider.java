package com.ldy.animdemo;

import android.content.Context;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

/**
 * Created by ldy on 2015/10/12.
 */
public class PlusActionProvider extends ActionProvider {

	public PlusActionProvider(Context context) {
		super(context);
	}

	@Override
	public View onCreateActionView() {
		return null;
	}

	@Override
	public void onPrepareSubMenu(SubMenu subMenu) {
		subMenu.clear();
		subMenu.add(SubMenu.NONE, 0, 0, "TFForeground");
		subMenu.add(SubMenu.NONE, 1, 1, "TFRotateDown");
		subMenu.add(SubMenu.NONE, 2, 2, "TFRotateUp");
		subMenu.add(SubMenu.NONE, 3, 3, "TFStack");
	}

	@Override
	public boolean hasSubMenu() {
		return true;
	}
}