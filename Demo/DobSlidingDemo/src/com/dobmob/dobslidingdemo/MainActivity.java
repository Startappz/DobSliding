package com.dobmob.dobslidingdemo;

<<<<<<< HEAD
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
=======
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
>>>>>>> 691d27f144cc9a44260457b32d4daab6a7264faa
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
<<<<<<< HEAD
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
=======
>>>>>>> 691d27f144cc9a44260457b32d4daab6a7264faa

import com.dobmob.dobsliding.DobSlidingMenu;
import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.dobmob.dobsliding.events.OnExpandedListener;
import com.dobmob.dobsliding.exceptions.NoActionBarException;
import com.dobmob.dobsliding.models.SlidingItem.SlidingType;

<<<<<<< HEAD
public class MainActivity extends ActionBarActivity {
=======
public class MainActivity extends Activity {
>>>>>>> 691d27f144cc9a44260457b32d4daab6a7264faa

	// Just a tag for Log
	private String TAG = getClass().getSimpleName();

	// Sliding menu object
	private DobSlidingMenu vSlidingMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// For GingerBreed and less, we must enable home button,
		// else, it is up to you
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
<<<<<<< HEAD
			getSupportActionBar().setHomeButtonEnabled(true);
=======

			// Uncomment
			// getSupportActionBar().setHomeButtonEnabled(true);
>>>>>>> 691d27f144cc9a44260457b32d4daab6a7264faa
		}

		// Initialization
		try {
			// Instance of this activity as a parameter
			vSlidingMenu = new DobSlidingMenu(this);

			// Sliding type can be resizing or moving
			vSlidingMenu.setSlidingType(SlidingType.SIZE);

			// The view that will be in sliding menu
			// We can assign XML layout or view
			vSlidingMenu.setSlidingView(R.layout.dob_sliding_menu);

			// This sentence is for handle that will be shown
			// in the middle of ActionBar,
			// default value is true
			vSlidingMenu.setUseHandle(true);

			// If we need to change handle icons
			// vSlidingMenu.setHandleImages(handleCollapsedIcon,
			// handleExpandedIcon);

			// The maximum duration for sliding
			// Default value is millisecond for each pixel
			// e.g. sliding view height is 1020 PX,
			// the duration will be 1020 MS
			vSlidingMenu.setMaxDuration(1000);

			// To access views in sliding menu
			View slidingView = vSlidingMenu.getSlidingView();
			slidingView.findViewById(R.id.clickMe).setOnClickListener(
					new OnClickListener() {

						@Override
						public void onClick(View v) {
							// Anything

							// sliding menu finish method to
							// collapse the sliding menu
							vSlidingMenu.finish();
						}
					});

			// Callback after collapsing
			vSlidingMenu.setOnCollapsedListener(new OnCollapsedListener() {

				@Override
				public void onCollapsed() {
					Log.i(TAG, "onCollapsed");
				}
			});

			// Callback after expanding
			vSlidingMenu.setOnExpandedListener(new OnExpandedListener() {

				@Override
				public void onExpanded() {
					Log.i(TAG, "onExpanded");
				}
			});
		} catch (NoActionBarException e) {
			e.printStackTrace();
		}

		initViews();
	}

	private void initViews() {
		findViewById(R.id.expand).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				vSlidingMenu.expand();

				// We can use collapse() also
			}
		});
<<<<<<< HEAD

		CheckBox enabledCheckBox = (CheckBox) findViewById(R.id.enabledCheckBox);
		enabledCheckBox.setChecked(vSlidingMenu.isEnabled());
		enabledCheckBox
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						// To enable / disable sliding menu
						vSlidingMenu.setEnabled(isChecked);
					}
				});
=======
>>>>>>> 691d27f144cc9a44260457b32d4daab6a7264faa
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
<<<<<<< HEAD
=======
		// Inflate the menu; this adds items to the action bar if it is present.
>>>>>>> 691d27f144cc9a44260457b32d4daab6a7264faa
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.action_size) {
			vSlidingMenu.setSlidingType(SlidingType.SIZE);
			return true;

		} else if (itemId == R.id.action_move) {
			vSlidingMenu.setSlidingType(SlidingType.MOVE);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

}
