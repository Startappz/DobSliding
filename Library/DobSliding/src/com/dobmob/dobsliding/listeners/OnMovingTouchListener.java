package com.dobmob.dobsliding.listeners;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

import com.dobmob.dobsliding.controllers.VSlidingMenuController;

public class OnMovingTouchListener implements OnTouchListener {

	private VSlidingMenuController vSlidingMenuController;

	private FrameLayout slidingParent;
	private FrameLayout.LayoutParams slidingLayoutParams;

	public OnMovingTouchListener(VSlidingMenuController vSlidingMenuController) {
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

				if (slidingLayoutParams.bottomMargin > 0) {
					return false;
				}

				break;

			case MotionEvent.ACTION_MOVE:
				slidingLayoutParams.topMargin = (int) y - slidingParent.getHeight();
				slidingParent.setLayoutParams(slidingLayoutParams);
				break;

			case MotionEvent.ACTION_UP:
				if (y > vSlidingMenuController.getJumpLine()) {
					vSlidingMenuController.animateSliding((int) y,
							(int) slidingParent.getHeight());

				} else {
					vSlidingMenuController.animateSliding((int) y, 0);
				}

				break;

			}
			
		}

		return true;
	}

}
