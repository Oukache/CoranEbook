package com.oukache.coranebook.ui;

import android.app.Activity;
import android.os.Bundle;

import com.oukache.coranebook.Injector;

import butterknife.ButterKnife;

/**
 * Created by Oukache on 16/03/2015.
 */
public class CoranebookFragmentActivity extends Activity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Injector.inject(this);
	}

	@Override
	public void setContentView(final int layoutResId) {
		super.setContentView(layoutResId);

		ButterKnife.inject(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}
}
