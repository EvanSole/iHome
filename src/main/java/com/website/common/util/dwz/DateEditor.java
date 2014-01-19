package com.website.common.util.dwz;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class DateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			setValue(null);
		}
	}

	@Override
	public String getAsText() {

		return getValue().toString();
	}
}
