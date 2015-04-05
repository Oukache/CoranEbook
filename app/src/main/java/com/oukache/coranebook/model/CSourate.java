package com.oukache.coranebook.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Oukache on 05/04/2015.
 */
public class CSourate implements Parcelable, Comparable<CSourate> {

	private int _sourate;
	private int _ayah;
	private int _page = -1;

	public CSourate(int sourate, int ayah) {
		_sourate = sourate;
		_ayah = ayah;
	}

	public CSourate(Parcel in) {
		_sourate = in.readInt();
		_ayah = in.readInt();
	}


	@Override
	public int compareTo(CSourate another) {
		return 0;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

	}
}
