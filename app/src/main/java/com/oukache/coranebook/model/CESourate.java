package com.oukache.coranebook.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Oukache on 05/04/2015.
 */
public class CESourate implements Parcelable, Comparable<CESourate> {

	private int _sourate;
	private int _ayah;
	private int _page = -1;

	public CESourate(int sourate, int ayah) {
		_sourate = sourate;
		_ayah = ayah;
	}

	public CESourate(Parcel in) {
		_sourate = in.readInt();
		_ayah = in.readInt();
	}

	@Override
	public boolean equals(Object o) {
		return (
				(o != null) &&
				(o.getClass() == CESourate.class) &&
				(((CESourate)o)._sourate == _sourate) &&
				((CESourate)o)._ayah == _ayah
			);
	}

	@Override
	public int compareTo(CESourate another) {
		if (this.equals(another)) {
			return 0;
		} else {
			return (_ayah < another._ayah) ? -1 : 1;
		}
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this._sourate);
		dest.writeInt(this._ayah);
	}

	public static final Creator<CESourate> CREATOR = new Creator<CESourate>() {

		@Override
		public CESourate createFromParcel(Parcel source) {
			return new CESourate(source);
		}

		@Override
		public CESourate[] newArray(int size) {
			return new CESourate[size];
		}
	};

}
