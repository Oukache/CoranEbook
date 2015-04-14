package com.oukache.coranebook;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * Created by Oukache on 14/04/2015.
 */
public class CoranEbookApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Injector.init(getModules());
	}

	protected Object getModules() {
		return new CoranebookModule();
	}

	public void inject(Object obj) {
		Injector.inject(obj);
	}
}
