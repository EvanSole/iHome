package com.website.common.util.log;

import java.util.logging.Logger;

public class Jdk14LogFactoryImpl implements LogFactory {

	public Log getLog(Class<?> c) {
		return getLog(c.getName());
	}

	public Log getLog(String name) {
		return new Jdk14LogImpl(Logger.getLogger(name));
	}

}