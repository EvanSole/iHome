package com.website.common.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.website.common.exception.BaseException;
import com.website.common.util.dwz.DateEditor;
import com.website.common.util.dwz.DoubleEditor;
import com.website.common.util.dwz.IntegerEditor;
import com.website.common.util.dwz.LongEditor;
import com.website.common.util.message.Message;

public abstract class BaseController {
	private ResourceBundleMessageSource res;
	

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.registerCustomEditor(int.class, new IntegerEditor());
		binder.registerCustomEditor(long.class, new LongEditor());
		binder.registerCustomEditor(double.class, new DoubleEditor());
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
	
	protected String getMessage(String code) {
		return this.getMessage(code, new Object[] {});
	}

	protected String getMessage(String code, Object arg0) {
		return getMessage(code, new Object[] { arg0 });
	}

	protected String getMessage(String code, Object arg0, Object arg1) {
		return getMessage(code, new Object[] { arg0, arg1 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2) {
		return getMessage(code, new Object[] { arg0, arg1, arg2 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2, Object arg3) {
		return getMessage(code, new Object[] { arg0, arg1, arg2, arg3 });
	}

	protected String getMessage(String code, Object[] args) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		Locale locale = localeResolver.resolveLocale(request);
		return getRes().getMessage(code, args, locale);
	}
	public ResourceBundleMessageSource getRes() {
		if (res == null) {
			res = new ResourceBundleMessageSource();
			res.setBasenames(new String[]{"res/messages"});
		}
		return res;
	}
	public void setRes(ResourceBundleMessageSource res) {
		this.res = res;
	}
	
	/** 基于@ExceptionHandler异常处理 */  
    @ExceptionHandler
    public @ResponseBody Object exp(HttpServletRequest request, Exception ex) {  
          Message message=new Message();
          
          System.out.println(ex);
          request.setAttribute("ex", ex);  
          System.out.println(getMessage("msg.login.failure"));
        // 根据不同错误转向不同页面  
        if(ex instanceof BaseException) {  
        	BaseException baseException=(BaseException)ex;
        	message.setMessage(getMessage(baseException.getMessage()));
            return message;  
        }
        
          return message;
    }  
    
   
}
