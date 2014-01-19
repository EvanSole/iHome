package com.website.common.util.log;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;

/**
 * <a href="LogUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LogUtil {

	public static final int STACK_TRACE_LENGTH = 20;

	public static final boolean REMOVE_UNKNOWN_SOURCE = true;

	public static void debug(Log log, Properties props) {
		if (log.isDebugEnabled()) {
			StringWriter sw = new StringWriter();

			props.list(new PrintWriter(sw));

			log.debug(sw.getBuffer().toString());
		}
	}

	public static void log(Log log, Throwable t) {
		if (t instanceof JspException) {
			log(log, (JspException)t);
		}
		else if (t instanceof ServletException) {
			log(log, (ServletException)t);
		}
		else {
			Throwable cause = t.getCause();

			if (cause != null) {
				log(log, cause);
			}
			else {
				_log(log, t);
			}
		}
	}

	public static void log(Log log, JspException jspe) {
		@SuppressWarnings("deprecation")
		Throwable cause = jspe.getRootCause();

		if (cause == null) {
			cause = jspe;
		}

		if ((cause != jspe) && (cause instanceof JspException)) {
			log(log, (JspException)cause);
		}
		else if (cause instanceof ServletException) {
			log(log, (ServletException)cause);
		}
		else {
			_log(log, cause);
		}
	}

	public static void log(Log log, ServletException se) {
		Throwable cause = se.getRootCause();

		if (cause == null) {
			cause = se;
		}

		if (cause instanceof JspException) {
			log(log, (JspException)cause);
		}
		else if ((cause != se) && (cause instanceof ServletException)) {
			log(log, (ServletException)cause);
		}
		else {
			_log(log, cause);
		}
	}

	private static void _log(Log log, Throwable cause) {
		StackTraceElement[] steArray = cause.getStackTrace();

		// Make the stack trace more readable by limiting the number of
		// elements.

		if (steArray.length > STACK_TRACE_LENGTH) {
			int count = 0;

			List<StackTraceElement> steList =
				new ArrayList<StackTraceElement>();

			for (int i = 0; i < steArray.length; i++) {
				StackTraceElement ste = steArray[i];

				// Make the stack trace more readable by removing elements that
				// refer to classes with no packages, or starts with a $, or are
				// Spring classes, or are standard reflection classes.

				String className = ste.getClassName();

				boolean addElement = true;

				if (REMOVE_UNKNOWN_SOURCE && (ste.getLineNumber() < 0)) {
					addElement = false;
				}

				if (className.startsWith("$") ||
					className.startsWith("java.lang.reflect.") ||
					className.startsWith("org.springframework.") ||
					className.startsWith("sun.reflect.")) {

					addElement = false;
				}

				if (addElement) {
					steList.add(ste);

					count++;
				}

				if (count >= STACK_TRACE_LENGTH) {
					break;
				}
			}

			steArray = steList.toArray(new StackTraceElement[steList.size()]);

			cause.setStackTrace(steArray);
		}

	}

}