package com.oukache.coranebook.model;

import android.graphics.RectF;
import android.support.annotation.NonNull;

/**
 * Created by Oukache on 05/04/2015.
 */
public class CAyahBounds {
	private int _line;
	private int _position;
	private RectF _limits;

	public CAyahBounds(Integer line, Integer pos, int left,
					   int top, int right, int bottom) {
		_line = line;
		_position = pos;
		_limits = new RectF(left, top, right, bottom);
	}

	public @NonNull RectF getLimits() {
		return _limits;
	}

	public void setLine(int line) {
		_line = line;
	}

	public int getLine() {
		return _line;
	}

	public void setPosition(int position) {
		_position = position;
	}

	public int getPosition() {
		return _position;
	}
}
