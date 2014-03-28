package com.dobmob.dobsliding.listeners;

import com.dobmob.dobsliding.controllers.VSlidingMenuController;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

public class OnSizingTouchListener implements OnTouchListener {

	private VSlidingMenuController vSlidingMenuController;

	private FrameLayout slidingParent;
	private FrameLayout.LayoutParams slidingLayoutParams;

	public OnSizingTouchListener(VSlidingMenuController vSlidingMenuController) {
		super();
		this.vSlidingMenuController = vSlidingMenuController;

		init();
	}

	private void init() {
		this.slidingParent = this.vSlidingMenuController.getSlidingParent();
		this.slidingLayoutParams = (FrameLayout.LayoutParams) this.slidingParent
				.getLayoutParams();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (vSlidingMenuController.getSlidingItem().isEnabled()) {
			float y = event.getY();

			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				vSlidingMenuController.focusOnSliding();

				if (slidingParent.getHeight() > 0) {
					return false;
				}

				break;

			case MotionEvent.ACTION_MOVE:
				slidingLayoutParams.height = (int) y;
				slidingParent.setLayoutParams(slidingLayoutParams);
				break;

			case MotionEvent.ACTION_UP:
				if (y > vSlidingMenuController.getJumpLine()) {
					vSlidingMenuController.animateSliding((int) y,
							vSlidingMenuController.getSlidingHeight());

				} else {
					vSlidingMenuController.animateSliding((int) y, 0);
				}

				break;

			}

		}

		return true;
	}

}
