package com.dobmob.dobsliding.listeners;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.dobmob.dobsliding.controllers.VSlidingMenuController;

public class SlidingParentTouchListener implements OnTouchListener {

	private VSlidingMenuController vSlidingMenuController;

	public SlidingParentTouchListener() {
		super();
	}

	public void register(VSlidingMenuController vSlidingMenuController) {
		this.vSlidingMenuController = vSlidingMenuController;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		vSlidingMenuController.finish();
		
		return true;
	}

}
