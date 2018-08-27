package com.dobmob.dobsliding.listeners;

import com.dobmob.dobsliding.controllers.VSlidingMenuController;

import android.view.View;
import android.view.View.OnClickListener;

public class HandleClickListener implements OnClickListener {

	private VSlidingMenuController vSlidingMenuController;

	public HandleClickListener(VSlidingMenuController vSlidingMenuController) {
		super();
		this.vSlidingMenuController = vSlidingMenuController;
	}

	@Override
	public void onClick(View v) {
		if (vSlidingMenuController.getSlidingStatus() == VSlidingMenuController.SlidingStatus.COLLAPSED) {
			vSlidingMenuController.expand();

		} else if (vSlidingMenuController.getSlidingStatus() == VSlidingMenuController.SlidingStatus.EXPANDED) {
			vSlidingMenuController.collapse();
		}
	}

}
