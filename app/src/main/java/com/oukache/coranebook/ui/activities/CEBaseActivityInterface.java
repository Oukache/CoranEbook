package com.oukache.coranebook.ui.activities;

import android.os.Handler;

/**
 * Auteur RADADI ALI Oukache.
 * <p/>
 * Copyright © 2016, DUNASYS. All rights reserved.
 */

public interface CEBaseActivityInterface {
	boolean canPerformTransaction();
	void destroyLoader(int i);
	Handler getHandler();
}
