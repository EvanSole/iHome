package com.website.common.util.log;

public interface LogFactory {

	public Log getLog(Class<?> c);

	public Log getLog(String name);

}