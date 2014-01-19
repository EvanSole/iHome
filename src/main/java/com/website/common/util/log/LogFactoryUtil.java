package com.website.common.util.log;

public class LogFactoryUtil {

	public static LogFactory getLogFactory() {
		return _logFactory;
	}

	public static void setLogFactory(LogFactory logFactory) {
		_logFactory.setLogFactory(logFactory);
	}

	public static Log getLog(Class<?> c) {
		return getLogFactory().getLog(c);
	}

	public static Log getLog(String name) {
		return getLogFactory().getLog(name);
	}

	private static LogFactoryWrapper _logFactory =
		new LogFactoryWrapper(new Jdk14LogFactoryImpl());

}