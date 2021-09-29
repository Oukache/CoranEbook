package com.oukache.coranebook.framework.net.api;

/**
 * Created by Oukache on 18/04/2015.
 *
 * coran ws response codes
 */
public enum CEResponseCodes {

	NETWORK_ERROR(-2),
	FAILURE(-1),
	SUCCESS(0);

	private int _code;

	CEResponseCodes(int val) {
		_code = val;
	}

	public int getCode() {
		return _code;
	}
}
