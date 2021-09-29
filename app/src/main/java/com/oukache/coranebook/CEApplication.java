package com.oukache.coranebook;

import android.app.Application;
import android.location.LocationManager;

import com.oukache.coranebook.presentation.MainActivity;
import com.oukache.coranebook.presentation.SplashScreen;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Oukache on 14/04/2015.
 */
public class CEApplication extends Application {

	@Singleton
	@Component(modules = AndroidModule.class)
	public interface CoranEbookComponent {
		void inject(CEApplication application);
		void inject(SplashScreen splashScreen);
		void inject(MainActivity baseActivity);
		// TODO : inject other activity & fragments
	}

	@Inject LocationManager locationManager;

	private CoranEbookComponent component;

	@Override
	public void onCreate() {
		super.onCreate();
		component = DaggerCoranEbookApplication_CoranEbookComponent.builder()
				.androidModule(new AndroidModule(this))
				.build();
		component.inject(this);
	}

	public CoranEbookComponent component() {
		return component;
	}

}
