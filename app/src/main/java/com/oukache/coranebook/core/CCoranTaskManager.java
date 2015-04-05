package com.oukache.coranebook.core;

import android.os.AsyncTask;

import java.util.concurrent.Executor;

/**
 * Created by Oukache on 05/04/2015.
 *
 * only for Sdk_ver > Honeycomb
 */
public class CCoranTaskManager {

	private CCoranTaskManager(){
		throw new UnsupportedOperationException();
	}

	public static <T> void asyncExecute(ICoranBackgroundWork<T> worker, ICoranTaskResponse<T> callback) {
		new CCoranTask<T>(worker, callback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
	}

	public static <T> void asyncExecute(ICoranBackgroundWork<T> worker, ICoranTaskResponse<T> callback,
										Executor executor) {
		new CCoranTask<T>(worker, callback).executeOnExecutor(executor);
	}
}
