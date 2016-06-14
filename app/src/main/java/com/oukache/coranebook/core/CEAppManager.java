package com.oukache.coranebook.core;

import android.content.Context;

/**
 * Auteur RADADI ALI Oukache.
 * <p/>
 * Copyright © 2016, DUNASYS. All rights reserved.
 */

public class CEAppManager {
	private static int sPlatform;
	private boolean mIsInitialized;

	private static class SingletonHolder {
		public static final CEAppManager sInstance;
		static {
			sInstance = new CEAppManager();
		}
	}

	private CEAppManager() {
	}

	public static CEAppManager getInstance() {
		return SingletonHolder.sInstance;
	}

	public static void init(Context context, int platform) {
		sPlatform = platform;
		//getInstance().setUserAgent(WebServices.getUserAgent(context));
	}
}
