package com.website.common.util.log;

public interface Log {

	public void debug(Object msg);

	public void debug(Throwable t);

	public void debug(Object msg, Throwable t);

	public void error(Object msg);

	public void error(Throwable t);

	public void error(Object msg, Throwable t);

	public void fatal(Object msg);

	public void fatal(Throwable t);

	public void fatal(Object msg, Throwable t);

	public void info(Object msg);

	public void info(Throwable t);

	public void info(Object msg, Throwable t);

	public boolean isDebugEnabled();

	public boolean isErrorEnabled();

	public boolean isFatalEnabled();

	public boolean isInfoEnabled();

	public boolean isTraceEnabled();

	public boolean isWarnEnabled();

	public void trace(Object msg);

	public void trace(Throwable t);

	public void trace(Object msg, Throwable t);

	public void warn(Object msg);

	public void warn(Throwable t);

	public void warn(Object msg, Throwable t);

}