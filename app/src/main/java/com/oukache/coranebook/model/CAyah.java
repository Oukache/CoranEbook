package com.oukache.coranebook.model;

import java.io.Serializable;

/**
 * Created by Oukache on 05/04/2015.
 */
public class CAyah implements Serializable {

	private int _sourate = 0;
	private int _ayah = 0;
	private String _content = null;
	private String _traduction = null;
	private boolean _isArabic = false;

	public CAyah(){
	}

	public CAyah(int sourate, int ayah) {
		_sourate = sourate;
		_ayah = ayah;
	}

	public int getSourate() {
		return _sourate;
	}

	public int getAyah() {
		return _ayah;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getTraduction() {
		return _traduction;
	}

	public void setTraduction(String traduction) {
		_traduction = traduction;
	}

	public boolean isArabic() {
		return _isArabic;
	}

	public void setArabic(boolean isArabic) {
		_isArabic = isArabic;
	}
}
