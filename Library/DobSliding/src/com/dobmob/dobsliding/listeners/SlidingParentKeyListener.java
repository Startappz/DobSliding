package com.dobmob.dobsliding.listeners;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

import com.dobmob.dobsliding.controllers.VSlidingMenuController;

public class SlidingParentKeyListener implements OnKeyListener {

	private VSlidingMenuController vSlidingMenuController;

	public SlidingParentKeyListener(
			VSlidingMenuController vSlidingMenuController) {
		super();
		this.vSlidingMenuController = vSlidingMenuController;
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (vSlidingMenuController.getSlidingStatus() == VSlidingMenuController.SlidingStatus.EXPANDED) {
				vSlidingMenuController.collapse();
				return true;

			} else {
				return false;
			}

		} else {
			return onKey(v, keyCode, event);
		}
	}

}
