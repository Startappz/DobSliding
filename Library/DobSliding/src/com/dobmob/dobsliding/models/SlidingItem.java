package com.dobmob.dobsliding.models;

import android.view.View;

import com.dobmob.dobsliding.R;
import com.dobmob.dobsliding.controllers.VSlidingMenuController;
import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.dobmob.dobsliding.events.OnExpandedListener;

public class SlidingItem {

	public enum SlidingType {
		SIZE, MOVE
	}

	private boolean enabled = true;
	private View slidingView;
	private SlidingType slidingType = SlidingType.SIZE;
	private int maxDuration = VSlidingMenuController.DEFAULT_INT;
	private float jumpLinePercentage = VSlidingMenuController.DEFAULT_JUMP_LINE_PERCENTAGE;
	private boolean useHandle = true;
	private int handleCollapsedIcon = R.drawable.ic_collapsed_dark;
	private int handleExpandedIcon = R.drawable.ic_expanded_dark;

	private OnCollapsedListener onCollapsedListener;
	private OnExpandedListener onExpandedListener;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public View getSlidingView() {
		return slidingView;
	}

	public void setSlidingView(View slidingView) {
		this.slidingView = slidingView;
	}

	public SlidingType getSlidingType() {
		return slidingType;
	}

	public void setSlidingType(SlidingType slidingType) {
		this.slidingType = slidingType;
	}

	public int getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(int maxDuration) {
		this.maxDuration = maxDuration;
	}

	public float getJumpLinePercentage() {
		return jumpLinePercentage;
	}

	public void setJumpLinePercentage(float jumpLinePercentage) {
		this.jumpLinePercentage = jumpLinePercentage;
	}

	public boolean isUseHandle() {
		return useHandle;
	}

	public void setUseHandle(boolean useHandle) {
		this.useHandle = useHandle;
	}

	public OnCollapsedListener getOnCollapsedListener() {
		return onCollapsedListener;
	}

	public void setOnCollapsedListener(OnCollapsedListener onCollapsedListener) {
		this.onCollapsedListener = onCollapsedListener;
	}

	public OnExpandedListener getOnExpandedListener() {
		return onExpandedListener;
	}

	public void setOnExpandedListener(OnExpandedListener onExpandedListener) {
		this.onExpandedListener = onExpandedListener;
	}

	public int getHandleCollapsedIcon() {
		return handleCollapsedIcon;
	}

	public void setHandleCollapsedIcon(int handleCollapsedIcon) {
		this.handleCollapsedIcon = handleCollapsedIcon;
	}

	public int getHandleExpandedIcon() {
		return handleExpandedIcon;
	}

	public void setHandleExpandedIcon(int handleExpandedIcon) {
		this.handleExpandedIcon = handleExpandedIcon;
	}
}
