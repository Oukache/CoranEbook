package com.oukache.coranebook.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.oukache.coranebook.Injector;
import com.oukache.coranebook.R;

import java.util.List;

import br.liveo.interfaces.NavigationLiveoListener;
import br.liveo.navigationliveo.NavigationLiveo;
import butterknife.ButterKnife;

/**
 * Created by Oukache on 16/03/2015.
 */
public class MainActivity extends NavigationLiveo implements NavigationLiveoListener {

	private List<String> _coranMenuItems;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Injector.inject(this);
	}

	@Override
	public void onUserInformation() {
		this.mUserName.setVisibility(View.GONE);
		this.mUserEmail.setVisibility(View.GONE);
		this.mUserPhoto.setVisibility(View.GONE);
	}

	@Override
	public void onInt(Bundle bundle) {

	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public void onItemClickNavigation(int i, int i2) {

	}

	@Override
	public void onPrepareOptionsMenuNavigation(Menu menu, int i, boolean b) {

	}

	@Override
	public void onClickFooterItemNavigation(View view) {

	}

	@Override
	public void onClickUserPhotoNavigation(View view) {

	}
}
