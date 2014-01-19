package com.website.common.util.message;

public class Message {

	private boolean success;
	
	private String targetUrl="";
	private String msg;
	private String callback="security";
	private int statusCode=200;
	private String message="";
	private String navTabId="";
	private String rel="";
	private String callbackType="";
	private String forwardUrl="";
	private Object callbackData=null;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNavTabId() {
		return navTabId;
	}
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getCallbackType() {
		return callbackType;
	}
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}
	public String getForwardUrl() {
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	/**
	 *success
	 * @return boolean
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success ,success 
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 *callbackData
	 * @return Object
	 */
	public Object getCallbackData() {
		return callbackData;
	}
	/**
	 * @param callbackData ,callbackData 
	 */
	public void setCallbackData(Object callbackData) {
		this.callbackData = callbackData;
	}
}
