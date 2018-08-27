package com.dobmob.dobsliding.listeners;

import com.dobmob.dobsliding.animations.AnimationExecutor;
import com.dobmob.dobsliding.controllers.VSlidingMenuController;
import com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

public class VSlidingAnimatorListener implements AnimatorListener {

	private VSlidingMenuController vSlidingMenuController;
	private AnimationExecutor.MovingType movingType;

	public VSlidingAnimatorListener(
			VSlidingMenuController vSlidingMenuController) {
		super();
		this.vSlidingMenuController = vSlidingMenuController;
	}
	public AnimationExecutor.MovingType getMovingType() {
		return movingType;
	}

	public void setMovingType(AnimationExecutor.MovingType movingType) {
		this.movingType = movingType;
	}

	@Override
	public void onAnimationStart(Animator animation) {
	}

	@Override
	public void onAnimationEnd(Animator animation) {
		if (vSlidingMenuController != null) {
			if (movingType == AnimationExecutor.MovingType.BOTTOM_TO_TOP) {
				vSlidingMenuController.changeHandle(SlidingStatus.COLLAPSED);

				if (vSlidingMenuController.getSlidingItem()
						.getOnCollapsedListener() != null) {
					
					vSlidingMenuController.getSlidingItem()
							.getOnCollapsedListener().onCollapsed();
				}

			} else if (movingType == AnimationExecutor.MovingType.TOP_TO_BOTTOM) {
				vSlidingMenuController.changeHandle(SlidingStatus.EXPANDED);

				if (vSlidingMenuController.getSlidingItem()
						.getOnExpandedListener() != null) {
					
					vSlidingMenuController.getSlidingItem()
							.getOnExpandedListener().onExpanded();
				}
			}
		}
	}

	@Override
	public void onAnimationCancel(Animator animation) {
	}

	@Override
	public void onAnimationRepeat(Animator animation) {
	}

}
