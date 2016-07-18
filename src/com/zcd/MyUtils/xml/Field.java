package com.zcd.MyUtils.xml;

import org.dom4j.Element;

public class Field {

	private String fieldName;
	private Boolean hasSon;
	private Element currentElement;
	private Element parentElement;
	
	/**
	 * 用来标识此节点是否同级下多个
	 */
	private Boolean isMultiple;
	
	public Boolean getIsMultiple() {
		return isMultiple;
	}
	public void setIsMultiple(Boolean isMultiple) {
		this.isMultiple = isMultiple;
	}
	public Element getCurrentElement() {
		return currentElement;
	}
	public void setCurrentElement(Element currentElement) {
		this.currentElement = currentElement;
	}
	public Element getParentElement() {
		return parentElement;
	}
	public void setParentElement(Element parentElement) {
		this.parentElement = parentElement;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Boolean getHasSon() {
		return hasSon;
	}
	public void setHasSon(Boolean hasSon) {
		this.hasSon = hasSon;
	}
	
	
	
}
