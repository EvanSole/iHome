package com.website.common.web.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Controller;

import com.website.common.util.StringUtils;
import com.website.common.util.log.Log;
import com.website.common.util.log.LogFactoryUtil;

/***
 * Method拦截器
 * @author Administrator
 *
 */
public class MethodAuthorityInterceptor implements MethodInterceptor {

	private static Log _log = LogFactoryUtil.getLog(StringUtils.class);
	public Object invoke(MethodInvocation invocation) throws Throwable {

		Class<?> clazz = invocation.getThis().getClass();

		if (clazz.isAnnotationPresent(Controller.class)) {
			Controller controller = clazz.getAnnotation(Controller.class);
			String controllerName = controller.value().trim();
			String methodName = invocation.getMethod().getName();
			_log.info("controller:"+controllerName +"\t\t methodName:"+methodName);
		}
		return invocation.proceed();
	}

}
