package com.free.testspring.utils;

import java.beans.PropertyEditorSupport;
import java.util.Map;

import com.free.testspring.domain.Role;

public class RolePropertyEditor extends PropertyEditorSupport{
	
	private Map<Long, Role> roleMap;
	
	public RolePropertyEditor(Map<Long, Role> roleMap) {
		this.roleMap = roleMap;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text == null || "".equals(text)) {
			super.setAsText(text);
		} else {
			Long id = Long.parseLong(text);
			Role role = roleMap.get(id);
			setValue(role);
		}
	}
	
	@Override
	public String getAsText() {
		Role role = (Role)getValue();
		return String.valueOf(role.getId());
	}
}
