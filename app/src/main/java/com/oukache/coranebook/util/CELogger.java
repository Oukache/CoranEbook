package com.oukache.coranebook.util;

import android.util.Log;

/**
 * Created by Oukache on 14/04/2015.
 * @brief	Gestion des logs de l'application
 */
public class CELogger {

	private static final String CORANEBOOK_TAG = "CoranEbook";
	public static final boolean ENABLE_LOG = true;

	private static boolean shouldLog()
	{
		return ENABLE_LOG;
	}

	private enum LOG_TYPE {
		WARNING,
		INFO,
		ERROR,
		VERBOSE,
		DEBUG
	}

	private static void logging(String message, LOG_TYPE type) {
		if (shouldLog()) {
			switch (type) {
				case WARNING :
					Log.w(CORANEBOOK_TAG, message);
					break;

				case INFO :
					Log.i(CORANEBOOK_TAG, message);
					break;

				case ERROR :
					Log.e(CORANEBOOK_TAG, message);
					break;

				case VERBOSE :
					Log.v(CORANEBOOK_TAG, message);
					break;

				case DEBUG :
				default :
					Log.d(CORANEBOOK_TAG, message);
					break;
			}
		}
	}

	public static void warning(String msg) {
		logging(msg, LOG_TYPE.WARNING);
	}

	public static void info(String msg) {
		logging(msg, LOG_TYPE.INFO);
	}

	public static void error(String msg) {
		logging(msg, LOG_TYPE.ERROR);
	}

	public static void verbose(String msg) {
		logging(msg, LOG_TYPE.VERBOSE);
	}

	public static void debug(String msg) {
		logging(msg, LOG_TYPE.DEBUG);
	}

}

