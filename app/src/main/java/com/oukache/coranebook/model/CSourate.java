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
	public boolean equals(Object o) {
		return (
				(o != null) &&
				(o.getClass() == CSourate.class) &&
				(((CSourate)o)._sourate == _sourate) &&
				((CSourate)o)._ayah == _ayah
			);
	}

	@Override
	public int compareTo(CSourate another) {
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

	public static final Creator<CSourate> CREATOR = new Creator<CSourate>() {

		@Override
		public CSourate createFromParcel(Parcel source) {
			return new CSourate(source);
		}

		@Override
		public CSourate[] newArray(int size) {
			return new CSourate[size];
		}
	};

}
