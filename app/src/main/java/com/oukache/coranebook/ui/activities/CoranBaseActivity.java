package com.oukache.coranebook.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.oukache.coranebook.R;
import com.oukache.coranebook.ui.fragments.FavorisFragment;
import com.oukache.coranebook.ui.fragments.SettingsFragment;
import com.oukache.coranebook.ui.fragments.ShareFragment;
import com.oukache.coranebook.ui.fragments.SourateFragment;
import com.oukache.coranebook.util.Constants;

/**
 * Created by Oukache on 16/03/2015.
 */
public class CoranBaseActivity extends ActionBarActivity {

	private SlidingPaneLayout slidingPaneLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		init();
		setNewPage(new SourateFragment(), Constants.FRAGMENT_SOURATE);
	}

	private void init() {
		slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);
	}

	public void setNewPage(Fragment fragment, int pageIndex) {
		if (slidingPaneLayout.isOpen()) {
			slidingPaneLayout.closePane();
		}
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.layout_frame, fragment, "currentFragment")
				.commit();

	}

	// TODO: utilisation de ViewPager pour les Views Sourate et Juz'
	public void onSourate(View v) {
		setNewPage(new SourateFragment(), Constants.FRAGMENT_SOURATE);
	}

	public void onFavoris(View v) {
		setNewPage(new FavorisFragment(), Constants.FRAGMENT_FAVORIS);
	}

	public void onShare(View v) {
		setNewPage(new ShareFragment(), Constants.FRAGMENT_SHARE);
	}

	public void onSettings(View v) {
		setNewPage(new SettingsFragment(), Constants.FRAGMENT_SETTINGS);
	}

	public void onSliding(View v) {
		if (slidingPaneLayout.isOpen()) {
			slidingPaneLayout.closePane();
		} else {
			slidingPaneLayout.openPane();
		}
	}

}
