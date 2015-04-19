package com.oukache.coranebook.model;

import android.content.Context;

import com.oukache.coranebook.R;

import javax.inject.Singleton;

/**
 * Created by Oukache on 05/04/2015.
 */
public class CCoranManager {

	//private static CCoranManager _instance = null;

	public static String getAyah(Context context) {
		return context.getString(R.string.ayah);
	}

	public static String getJuz(Context context) {
		return context.getString(R.string.juz);
	}

	//public String getSourate(Context context, )
}
