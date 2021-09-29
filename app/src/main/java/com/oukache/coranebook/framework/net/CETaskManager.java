package com.oukache.coranebook.framework.net;

import android.os.AsyncTask;

import java.util.concurrent.Executor;

/**
 * Created by Oukache on 05/04/2015.
 *
 * only for Sdk_ver > Honeycomb
 */
public class CETaskManager {

	private CETaskManager(){
		throw new UnsupportedOperationException();
	}

	public static <T> void asyncExecute(ICEBackgroundWork<T> worker, ICETaskResponse<T> callback) {
		new CETask<T>(worker, callback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
	}

	public static <T> void asyncExecute(ICEBackgroundWork<T> worker, ICETaskResponse<T> callback,
										Executor executor) {
		new CETask<T>(worker, callback).executeOnExecutor(executor);
	}
}
