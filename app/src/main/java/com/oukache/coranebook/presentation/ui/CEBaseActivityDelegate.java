package com.oukache.coranebook.presentation.ui;

import android.os.Bundle;
import android.os.Handler;

import androidx.fragment.app.FragmentActivity;


/**
 * Auteur RADADI ALI Oukache.
 * <p/>
 * Copyright © 2016, DUNASYS. All rights reserved.
 */

public class CEBaseActivityDelegate<T extends FragmentActivity & CEBaseActivityInterface> {
	private T mActivity;
	private boolean mCanPerformTransaction;
	private Handler mHandler;

	public CEBaseActivityDelegate(T activity) {
		this.mCanPerformTransaction = false;
		this.mActivity = activity;
	}

	public void onCreate(Bundle savedInstanceState) {
		this.mCanPerformTransaction = true;
		this.mHandler = new Handler();
	}

	public void onStart() {
		this.mCanPerformTransaction = true;
	}

	public void onPause() {
		this.mHandler.removeCallbacksAndMessages(null);
	}

	public void onSaveInstanceState(Bundle outState) {
		this.mCanPerformTransaction = false;
	}

	public boolean canPerformTransaction() {
		return this.mCanPerformTransaction;
	}

	public Handler getHandler() {
		return this.mHandler;
	}

	public void destroyLoader(final int id) {
		this.mHandler.post(new Runnable() {
			@Override
			public void run() {
				mActivity.getSupportLoaderManager().destroyLoader(id);
			}
		});
	}
}
