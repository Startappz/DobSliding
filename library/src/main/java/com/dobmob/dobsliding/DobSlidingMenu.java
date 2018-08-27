package com.dobmob.dobsliding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import com.dobmob.dobsliding.controllers.VSlidingMenuController;
import com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus;
import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.dobmob.dobsliding.events.OnExpandedListener;
import com.dobmob.dobsliding.exceptions.NoActionBarException;
import com.dobmob.dobsliding.models.SlidingItem;
import com.dobmob.dobsliding.models.SlidingItem.SlidingType;

public class DobSlidingMenu {

	private Activity activity;
	private SlidingItem slidingItem;
	private VSlidingMenuController vSlidingMenuController;

	public DobSlidingMenu(Activity activity) throws NoActionBarException {
		super();
		this.activity = activity;
		
		init();
	}

	private void init() throws NoActionBarException {
		slidingItem = new SlidingItem();
		vSlidingMenuController = new VSlidingMenuController(activity, slidingItem);
	}
	
	public void expand() {
		vSlidingMenuController.expand();
	}

	public void collapse() {
		vSlidingMenuController.collapse();
	}

	public void finish() {
		vSlidingMenuController.finish();
	}
	
	public SlidingStatus getSlidingStatus() {
		return vSlidingMenuController.getSlidingStatus();
	}

	public View getSlidingView() {
		return slidingItem.getSlidingView();
	}

	public void setSlidingView(View slidingView) {
		slidingItem.setSlidingView(slidingView);
		vSlidingMenuController.setSlidingView(slidingView);
	}
	
	public void setSlidingView(int slidingResId) {
		View slidingView = LayoutInflater.from(activity)
				.inflate(slidingResId, null, false);

		setSlidingView(slidingView);
	}

	public SlidingType getSlidingType() {
		return slidingItem.getSlidingType();
	}

	public void setSlidingType(SlidingType slidingType) {
		slidingItem.setSlidingType(slidingType);
		vSlidingMenuController.setSlidingType(slidingType);
	}

	public int getMaxDuration() {
		return slidingItem.getMaxDuration();
	}

	public void setMaxDuration(int maxDuration) {
		slidingItem.setMaxDuration(maxDuration);
	}

	public float getJumpLinePercentage() {
		return slidingItem.getJumpLinePercentage();
	}

	public void setJumpLinePercentage(float jumpLinePercentage) {
		slidingItem.setJumpLinePercentage(jumpLinePercentage);
	}

	public boolean isUseHandle() {
		return slidingItem.isUseHandle();
	}

	public void setUseHandle(boolean useHandle) {
		slidingItem.setUseHandle(useHandle);
		vSlidingMenuController.setUseHandle(useHandle);
	}

	public void setHandleImages(int handleCollapsedIcon, int handleExpandedIcon) {
		slidingItem.setHandleCollapsedIcon(handleCollapsedIcon);
		slidingItem.setHandleExpandedIcon(handleExpandedIcon);
		
		vSlidingMenuController.changeHandle(getSlidingStatus());
	}

	public OnCollapsedListener getOnCollapsedListener() {
		return slidingItem.getOnCollapsedListener();
	}

	public void setOnCollapsedListener(OnCollapsedListener onCollapsedListener) {
		slidingItem.setOnCollapsedListener(onCollapsedListener);
	}

	public OnExpandedListener getOnExpandedListener() {
		return slidingItem.getOnExpandedListener();
	}

	public void setOnExpandedListener(OnExpandedListener onExpandedListener) {
		slidingItem.setOnExpandedListener(onExpandedListener);
	}

}
