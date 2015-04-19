package com.oukache.coranebook.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Oukache on 19/04/2015.
 */
public class CNetworkState {

	private final ConnectivityManager _connectivityManager;

	public CNetworkState(ConnectivityManager connectivityManager) {
		_connectivityManager = connectivityManager;
	}

	public boolean isConnectedOrConnecting() {
		NetworkInfo netInfo = _connectivityManager.getActiveNetworkInfo();
		return netInfo.isConnectedOrConnecting();
	}
}
