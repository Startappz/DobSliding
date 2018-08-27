package com.dobmob.dobsliding.utils;

import android.widget.FrameLayout;

import com.dobmob.dobsliding.controllers.VSlidingMenuController;
import com.dobmob.dobsliding.models.SlidingItem.SlidingType;

public class Computer {

	public static VSlidingMenuController.SlidingStatus getSlidingStatus(
			VSlidingMenuController vSlidingMenuController) {

		FrameLayout slidingParent = vSlidingMenuController.getSlidingParent();
		FrameLayout.LayoutParams slidingLayoutParams = (FrameLayout.LayoutParams) slidingParent
				.getLayoutParams();

		if (vSlidingMenuController.getSlidingItem().getSlidingType() == SlidingType.SIZE) {

			int currentSlidingHeight = slidingParent.getHeight();

			if (currentSlidingHeight == 0) {
				return VSlidingMenuController.SlidingStatus.COLLAPSED;

			} else if (currentSlidingHeight >= vSlidingMenuController
					.getSlidingHeight()) {
				return VSlidingMenuController.SlidingStatus.EXPANDED;

			} else {
				return VSlidingMenuController.SlidingStatus.ANIMATING;
			}

		} else if (vSlidingMenuController.getSlidingItem().getSlidingType() == SlidingType.MOVE) {

			int currentSlidingTop = slidingLayoutParams.topMargin;

			if (currentSlidingTop <= -vSlidingMenuController.getSlidingHeight()) {
				return VSlidingMenuController.SlidingStatus.COLLAPSED;

			} else if (currentSlidingTop >= 0) {
				return VSlidingMenuController.SlidingStatus.EXPANDED;

			} else {
				return VSlidingMenuController.SlidingStatus.ANIMATING;
			}

		} else {
			return VSlidingMenuController.SlidingStatus.ANIMATING;
		}
	}

}
