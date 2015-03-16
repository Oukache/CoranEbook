package com.oukache.coranebook;

import dagger.ObjectGraph;

/**
 * Created by Oukache on 16/03/2015.
 */
public final class Injector {

	private static ObjectGraph _objectGraph = null;

	public static void init(final Object module) {
		if (_objectGraph == null) {
			_objectGraph = ObjectGraph.create(module);
		} else {
			_objectGraph = _objectGraph.plus(module);
		}
		_objectGraph.injectStatics();
	}

	public static void init(final Object module, final Object target) {
		init(module);
		inject(target);
	}

	public static void inject(final Object target) {
		_objectGraph.inject(target);
	}

	public static <T> T resolve(Class<T> type) {
		return _objectGraph.get(type);
	}
}
