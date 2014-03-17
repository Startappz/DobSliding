DobSliding
==========


DobSliding [(Google Play Demo)](https://play.google.com/store/apps/details?id=com.dobmob.dobslidingdemo)
--------------------------------------------------

There are more than one horizontal sliding menu library for Android, but what about a vertical sliding?

DobSliding is an Open Source Android library that allows developers to develop applications with vertical sliding menus just like the Android notifications menu.

![alt tag](https://raw.github.com/bilalsammour/DobSliding/master/screenshot1.png)

Here is a short video for the example application in this repository : [http://youtu.be/_zOkV6nxu98](http://youtu.be/_zOkV6nxu98)


Setup
-----

In Eclipse, just import the library as an Android library project. Project > Clean to generate the binaries you need, like R.java, etc. Then, just add DobSliding as a dependency to your existing project.


How?
----

In order to integrate DobSliding into your projects, take a look to the sample project, also, this is an example: dob_sliding_menu.xml

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#44000000"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin" >

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:text="@string/v_sliding_menu"
        android:textAppearance="?android:attr/textAppearanceLarge" />

    <Button
        android:id="@+id/clickMe"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:text="@string/click_me" />

    <ToggleButton
        android:id="@+id/toggleMe"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:text="@string/toggle_me" />

</RelativeLayout>
```

MainActivity.java

```java
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// For GingerBreed and less, we must enable home button,
		// else, it is up to you
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
			getSupportActionBar().setHomeButtonEnabled(true);
		}

		// Initialization
		try {
			// Instance of this activity as a parameter
			vSlidingMenu = new DobSlidingMenu(this);

			// Sliding type can be sizing or moving
			vSlidingMenu.setSlidingType(SlidingType.SIZE);

			// The view that will be in sliding menu
			// We can assign XML layout or view
			vSlidingMenu.setSlidingView(R.layout.dob_sliding_menu);

			// This sentence is for handle that will be shown
			// in the middle of ActionBar,
			// default value is true
			vSlidingMenu.setUseHandle(true);

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
		
	}
```

For ActionBarSherlock and CompactActionBar
------------------------------------------

DobSliding works perfectly in both ActionBarSherlock and CompactActionBar. For Android GingerBread and less, don't forget to write

```java
getSupportActionBar().setHomeButtonEnabled(true);
```


Properties
----------

* slidingType - Sliding type can be SIZE, MOVE
* slidingStatus - COLLAPSED, EXPANDED, ANIMATING
* maxDuration - The maximum duration for sliding, default value is millisecond for each pixel, e.g. sliding view height is 1020 PX, the duration will be 1020 MS
* jumpLinePercentage - The percentage of screen height in which the sliding menu will be expanded on scrolling, e.g. if jumpLinePercentage is 0.6, user will scroll to 0.6 of screen to expand
* useHandle - This sentence is for handle that will be shown in the middle of ActionBar, default value is true
* handleImages - To change images for the handle in ActionBar
* OnCollapsedListener
* OnExpandedListener


Methods
-------

* finish() - To be called on click listener for a button in the sliding menu
* collapse()
* expand()


Events
------

* OnCollapsedListener - Callback after collapsing
* OnExpandedListener - Callback after expanding


Developed By
------------

Bilal Sammour - bilalsammour@gmail.com


License
-------

    Copyright 2014 Bilal Sammour
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


Note
----

I developed DobSliding while I am working in Startappz company, so you can find the library in
[https://github.com/Startappz/DobSliding](https://github.com/Startappz/DobSliding)