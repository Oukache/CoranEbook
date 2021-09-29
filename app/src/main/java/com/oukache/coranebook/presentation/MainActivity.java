package com.oukache.coranebook.presentation;

import android.os.Bundle;
import android.view.View;

import androidx.slidingpanelayout.widget.SlidingPaneLayout;

import com.oukache.coranebook.CEApplication;
import com.oukache.coranebook.R;
import com.oukache.coranebook.presentation.ui.doua.DouaFragment;
import com.oukache.coranebook.presentation.ui.favoris.FavorisFragment;
import com.oukache.coranebook.presentation.ui.hadiths.HadithsFragment;
import com.oukache.coranebook.presentation.ui.settings.SettingsFragment;
import com.oukache.coranebook.presentation.ui.sourate.SourateFragment;


/**
 * Created by Oukache on 16/03/2015.
 */
public class MainActivity extends CEBaseActivity {

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
