package com.oukache.coranebook.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.oukache.coranebook.CEApplication;
import com.oukache.coranebook.R;
import com.oukache.coranebook.ui.fragments.DouaFragment;
import com.oukache.coranebook.ui.fragments.FavorisFragment;
import com.oukache.coranebook.ui.fragments.HadithsFragment;
import com.oukache.coranebook.ui.fragments.SettingsFragment;
import com.oukache.coranebook.ui.fragments.SourateFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Oukache on 16/03/2015.
 */
public class MainActivity extends ActionBarActivity {

	@BindView(R.id.sliding_pane_layout)
	SlidingPaneLayout slidingPaneLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_main);
		// inject
		((CEApplication) getApplication()).component().inject(this);
		ButterKnife.bind(this);
		showFragment(new SourateFragment());
	}

	public void showFragment(Fragment fragment) {
		showFragment(fragment, false);
	}

	public void showFragment(Fragment fragment, boolean retain) {
		if (slidingPaneLayout.isOpen()) {
			slidingPaneLayout.closePane();
		}
		FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
		if (retain) {
			tr.addToBackStack(null);
		}
		tr.replace(R.id.layout_frame, fragment, "currentFragment");
		tr.commit();
	}

	// TODO: utilisation de ViewPager pour les Views Sourate et Juz'
	public void onSourate(View v) {
		showFragment(new SourateFragment(), false);
	}

	public void onFavoris(View v) {
		showFragment(new FavorisFragment(), true);
	}

	public void onHadiths(View v) {
		showFragment(new HadithsFragment(), true);
	}

	public void onDoua(View v) {
		showFragment(new DouaFragment(), true);
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
