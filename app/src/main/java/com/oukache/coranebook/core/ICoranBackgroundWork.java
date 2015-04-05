package com.oukache.coranebook.core;

/**
 * Created by Oukache on 05/04/2015.
 */
public interface ICoranBackgroundWork<T> {
	abstract T performWork() throws Exception;
}
