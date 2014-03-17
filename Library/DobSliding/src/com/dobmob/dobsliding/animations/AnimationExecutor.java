package com.dobmob.dobsliding.animations;

import com.dobmob.dobsliding.controllers.VSlidingMenuController;
import com.dobmob.dobsliding.listeners.VSlidingAnimatorListener;
import com.dobmob.dobsliding.models.SlidingItem.SlidingType;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

public class AnimationExecutor {

	private VSlidingMenuController vSlidingMenuController;

	public AnimationExecutor(VSlidingMenuController vSlidingMenuController) {
		super();
		this.vSlidingMenuController = vSlidingMenuController;
	}

	public enum MovingType {
		TOP_TO_BOTTOM, BOTTOM_TO_TOP
	}

	public void animateView(int fromY, int toY) {
		int duration = Math.abs(toY - fromY);

		if (vSlidingMenuController.getSlidingItem().getMaxDuration() > VSlidingMenuController.DEFAULT_INT) {
			duration = Math.min(duration, vSlidingMenuController
					.getSlidingItem().getMaxDuration());
		}

		VSlidingAnimatorListener animatorListener = new VSlidingAnimatorListener(
				vSlidingMenuController);

		MovingType movingType = toY == 0 ? MovingType.BOTTOM_TO_TOP
				: MovingType.TOP_TO_BOTTOM;
		animatorListener.setMovingType(movingType);

		String propertyName = "";
		if (vSlidingMenuController.getSlidingItem().getSlidingType() == SlidingType.SIZE) {
			propertyName = "viewHeight";

		} else if (vSlidingMenuController.getSlidingItem().getSlidingType() == SlidingType.MOVE) {
			propertyName = "viewTop";
		}

		ValueAnimator sizeAnim = ObjectAnimator.ofInt(vSlidingMenuController,
				propertyName, fromY, toY);
		sizeAnim.setDuration(duration);
		sizeAnim.addListener(animatorListener);
		sizeAnim.start();
	}

}
