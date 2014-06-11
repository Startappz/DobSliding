package com.dobmob.dobsliding.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.dobmob.dobsliding.controllers.VSlidingMenuController;
import com.dobmob.dobsliding.exceptions.NoActionBarException;
import com.dobmob.dobsliding.models.SlidingItem;

public class Initializer {

	@SuppressLint("InlinedApi")
	public static View getActionBarView(ViewGroup decor)
			throws NoActionBarException {
		View actionBarView;
		Context context = decor.getContext();

		View home = decor.findViewById(android.R.id.home);
		if (home == null) {
			int homeId = context.getResources().getIdentifier("abs__home",
					"id", context.getPackageName());
			home = decor.findViewById(homeId);
		}

		if (home == null) {
	            //if home is still null, which is the case for GINGERBREAD_MR1 even if we enabled home button,
	            //we search for actionBarView by id
	            actionBarView = findActionBarView(decor);
	        } else {
	            actionBarView = (View) home.getParent().getParent().getParent();
	        }
	        if (actionBarView == null) {
	            throw new NoActionBarException();
	        }
		return actionBarView;
	}
	
	private static View findActionBarView(ViewGroup in) {
	        for (int i = 0; i < in.getChildCount(); i++) {
	            View v = in.getChildAt(i);
	            try {
	                if (v.getId() != View.NO_ID) {
	                    if (v.getResources().getResourceEntryName(v.getId()).equals("action_bar")) {
	                        return v;
	                    }
	                }
	            } catch (Exception ignore) {
	            }
	
	            if (v instanceof ViewGroup) {
	                View vv = findActionBarView((ViewGroup) v);
	                if (vv != null) return vv;
	            }
	        }
	        return null;
        }

	public static ImageView initHandle(Context context,
			VSlidingMenuController slidingMenuController,
			SlidingItem slidingItem) {
		ImageView handle = new ImageView(context);
		handle.setImageResource(slidingItem.getHandleCollapsedIcon());
		handle.setScaleType(ImageView.ScaleType.CENTER);
		handle.setContentDescription("");

		FrameLayout.LayoutParams handleLayoutParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.WRAP_CONTENT,
				FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM
						| Gravity.CENTER_HORIZONTAL);
		handle.setLayoutParams(handleLayoutParams);

		return handle;
	}
}
