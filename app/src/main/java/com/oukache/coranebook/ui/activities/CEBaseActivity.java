package com.oukache.coranebook.ui.activities;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


/**
 * Auteur RADADI ALI Oukache.
 * <p/>
 * CoranEbook base activity.
 * <p/>
 * Copyright © 2016, DUNASYS. All rights reserved.
 */

public class CEBaseActivity extends AppCompatActivity implements CEBaseActivityInterface {

	private CEBaseActivityDelegate<CEBaseActivity> mDelegate;

	public CEBaseActivity() {
		this.mDelegate = new CEBaseActivityDelegate(this);
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.mDelegate.onCreate(savedInstanceState);
		if (!allowOrientationChange()) {
			if (AppManager.getInstance().isTablet()) {
				// 6
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
			} else {
				// 1
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			}
		}
	}

	protected void onDestroy() {
		super.onDestroy();
	}

	protected void onResume() {
		super.onResume();
	}

	protected void onStart() {
		super.onStart();
		this.mDelegate.onStart();
	}

	protected void onPause() {
		super.onPause();
		this.mDelegate.onPause();
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		this.mDelegate.onSaveInstanceState(outState);
	}

	protected void attachBaseContext(Context newBase) {
		super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
	}

	public boolean canPerformTransaction() {
		return this.mDelegate.canPerformTransaction();
	}

	public Handler getHandler() {
		return this.mDelegate.getHandler();
	}

	public void destroyLoader(int id) {
		this.mDelegate.destroyLoader(id);
	}

	protected boolean allowOrientationChange() {
		return false;
	}
}
