package com.oukache.coranebook.core.api;

/**
 * Created by Oukache on 18/04/2015.
 *
 * coran ws response codes
 */
public enum CoranResponseCodes {

	NETWORK_ERROR(-2),
	FAILURE(-1),
	SUCCESS(0);

	private int _code;

	CoranResponseCodes(int val) {
		_code = val;
	}

	public int getCode() {
		return _code;
	}
}
