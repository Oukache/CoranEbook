package com.oukache.coranebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Oukache on 18/04/2015.
 */
@Module
public class AndroidModule {

	private final CEApplication _application;

	public AndroidModule(CEApplication application) {
		_application = application;
	}

	@Provides
	@Singleton @ForApplication
	Context provideApplicationContext() {
		return _application;
	}

	@Provides
	@Singleton
	Resources provideResources() {
		return _application.getResources();
	}

	@Provides
	@Singleton
	LocationManager provideLocationManager() {
		return (LocationManager) _application.getSystemService(Context.LOCATION_SERVICE);
	}

	@Provides
	@Singleton
	LayoutInflater provideLayoutInflater() {
		return (LayoutInflater) _application.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Provides
	@Singleton
	SharedPreferences providePreferenceManager() {
		return PreferenceManager.getDefaultSharedPreferences(_application);
	}

	@Provides
	@Singleton
	ConnectivityManager provideConnectivityManager() {
		return (ConnectivityManager) _application.getSystemService(Context.CONNECTIVITY_SERVICE);
	}

	/*
	@Provides
	@Singleton
	CNetworkState provideNetworkState
	*/
}
