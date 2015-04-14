package com.oukache.coranebook;

import com.oukache.coranebook.ui.activities.CoranBaseActivity;
import com.oukache.coranebook.ui.activities.SplashScreen;

import dagger.Module;

/**
 * Created by Oukache on 16/03/2015.
 */

@Module(
		injects = {
				SplashScreen.class,
				CoranBaseActivity.class
		},
		complete = false
)

public class CoranebookModule {
	// providing
}
