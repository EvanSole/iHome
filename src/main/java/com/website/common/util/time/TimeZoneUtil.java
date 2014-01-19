package com.website.common.util.time;

import java.util.TimeZone;

import com.website.common.util.StringPool;
import com.website.common.util.Validator;

public class TimeZoneUtil {

	public static TimeZone getDefault() {
		return _instance._getDefault();
	}

	public static TimeZone getTimeZone(String timeZoneId) {
		return TimeZone.getTimeZone(timeZoneId);
	}

	public static void setDefault(String id) {
		_instance._setDefault(id);
	}

	private TimeZoneUtil() {
		_timeZone = TimeZone.getTimeZone(StringPool.UTC);
	}

	private TimeZone _getDefault() {
		return _timeZone;
	}

	private void _setDefault(String id) {
		if (Validator.isNotNull(id)) {
			_timeZone = TimeZone.getTimeZone(id);
		}
	}

	private static TimeZoneUtil _instance = new TimeZoneUtil();

	private TimeZone _timeZone;

}