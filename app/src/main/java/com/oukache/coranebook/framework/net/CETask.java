package com.oukache.coranebook.framework.net;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * Created by Oukache on 05/04/2015.
 */
public class CETask<T> extends AsyncTask<Void, Void, T> {
	private ICEBackgroundWork<T> _worker;
	private ICETaskResponse<T> _callback;
	private Exception _exception;

	public CETask(@NonNull ICEBackgroundWork<T> worker, @NonNull ICETaskResponse<T> callback) {
		_worker = worker;
		_callback = callback;
	}

	@Override
	protected T doInBackground(Void... params) {
		try {
			return _worker.performWork();
		} catch(Exception e) {
			_exception = e;
			return null;
		}
	}

	@Override
	protected void onPostExecute(T result) {
		if(!isCancelled()) {
			if(_exception != null) {
				_callback.onFailure(_exception);
			} else {
				_callback.onSuccess(result);
			}
		} else {
			_callback.onFailure(new RuntimeException("task was cancelled"));
		}
	}

}