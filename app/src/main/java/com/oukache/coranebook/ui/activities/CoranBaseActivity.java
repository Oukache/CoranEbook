package com.oukache.coranebook.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.oukache.coranebook.CoranEbookApplication;
import com.oukache.coranebook.R;
import com.oukache.coranebook.ui.fragments.FavorisFragment;
import com.oukache.coranebook.ui.fragments.SettingsFragment;
import com.oukache.coranebook.ui.fragments.ShareFragment;
import com.oukache.coranebook.ui.fragments.SourateFragment;
import com.oukache.coranebook.util.Constants;

import butterknife.InjectView;

/**
 * Created by Oukache on 16/03/2015.
 */
public class CoranBaseActivity extends ActionBarActivity {

	@InjectView(R.id.sliding_pane_layout) SlidingPaneLayout slidingPaneLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		// inject
		((CoranEbookApplication) getApplication()).component().inject(this);
		showFragment(new SourateFragment());
	}

	public void showFragment(Fragment fragment) {
		showFragment(fragment, false);
	}

	public void showFragment(Fragment fragment, boolean retain) {
		if (slidingPaneLayout.isOpen()) {
			slidingPaneLayout.closePane();
		}
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.layout_frame, fragment, "currentFragment")
				.commit();
	}

	// TODO: utilisation de ViewPager pour les Views Sourate et Juz'
	public void onSourate(View v) {
		showFragment(new SourateFragment(), false);
	}

	public void onFavoris(View v) {
		showFragment(new FavorisFragment(), true);
	}

	public void onShare(View v) {
		showFragment(new ShareFragment(), true);
	}

	public void onSettings(View v) {
		showFragment(new SettingsFragment(), true);
	}

	public void onSliding(View v) {
		if (slidingPaneLayout.isOpen()) {
			slidingPaneLayout.closePane();
		} else {
			slidingPaneLayout.openPane();
		}
	}

}
