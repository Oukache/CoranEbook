package com.oukache.coranebook.framework.net;

/**
 * Created by Oukache on 05/04/2015.
 */
public interface ICETaskResponse<T> {
	public void onSuccess(T result);
	public void onFailure(Exception e);
}
