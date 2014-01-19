package com.website.common.util.log;

public class LogWrapper implements Log {

	public LogWrapper(Log log) {
		_log = log;
	}

	public void setLog(Log log) {
		_log = log;
	}

	public void debug(Object msg) {
		try {
			_log.debug(msg);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	public void debug(Throwable t) {
		try {
			_log.debug(t);
		} catch (Exception e) {
			printMsg(t.getMessage());
		}
	}

	public void debug(Object msg, Throwable t) {
		try {
			_log.debug(msg, t);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	public void error(Object msg) {
		try {
			_log.error(msg);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	public void error(Throwable t) {
		try {
			_log.error(t);
		} catch (Exception e) {
			printMsg(t.getMessage());
		}
	}

	public void error(Object msg, Throwable t) {
		try {
			_log.error(msg, t);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	public void fatal(Object msg) {
		try {
			_log.fatal(msg);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	public void fatal(Throwable t) {
		try {
			_log.fatal(t);
		} catch (Exception e) {
			printMsg(t.getMessage());
		}
	}

	public void fatal(Object msg, Throwable t) {
		try {
			_log.fatal(msg, t);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	public void info(Object msg) {
		try {
			_log.info(msg);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	public void info(Throwable t) {
		try {
			_log.info(t);
		} catch (Exception e) {
			printMsg(t.getMessage());
		}
	}

	public void info(Object msg, Throwable t) {
		try {
			_log.info(msg, t);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	public boolean isDebugEnabled() {
		return _log.isDebugEnabled();
	}

	public boolean isErrorEnabled() {
		return _log.isErrorEnabled();
	}

	public boolean isFatalEnabled() {
		return _log.isFatalEnabled();
	}

	public boolean isInfoEnabled() {
		return _log.isInfoEnabled();
	}

	public boolean isTraceEnabled() {
		return _log.isTraceEnabled();
	}

	public boolean isWarnEnabled() {
		return _log.isWarnEnabled();
	}

	public void trace(Object msg) {
		try {
			_log.trace(msg);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	public void trace(Throwable t) {
		try {
			_log.trace(t);
		} catch (Exception e) {
			printMsg(t.getMessage());
		}
	}

	public void trace(Object msg, Throwable t) {
		try {
			_log.trace(msg, t);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	public void warn(Object msg) {
		try {
			_log.warn(msg);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	public void warn(Throwable t) {
		try {
			_log.warn(t);
		} catch (Exception e) {
			printMsg(t.getMessage());
		}
	}

	public void warn(Object msg, Throwable t) {
		try {
			_log.warn(msg, t);
		} catch (Exception e) {
			printMsg(msg);
		}
	}

	protected void printMsg(Object msg) {
		System.err.println(msg);
	}

	private Log _log;

}