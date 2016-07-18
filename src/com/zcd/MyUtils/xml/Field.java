package com.zcd.MyUtils.xml;

import org.dom4j.Element;

public class Field implements Comparable<Field>{

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentElement == null) ? 0 : currentElement.hashCode());
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + ((hasSon == null) ? 0 : hasSon.hashCode());
		result = prime * result + ((isMultiple == null) ? 0 : isMultiple.hashCode());
		result = prime * result + ((parentElement == null) ? 0 : parentElement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Field other = (Field) obj;
		if (currentElement == null) {
			if (other.currentElement != null)
				return false;
		} else if (!currentElement.equals(other.currentElement))
			return false;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (hasSon == null) {
			if (other.hasSon != null)
				return false;
		} else if (!hasSon.equals(other.hasSon))
			return false;
		if (isMultiple == null) {
			if (other.isMultiple != null)
				return false;
		} else if (!isMultiple.equals(other.isMultiple))
			return false;
		if (parentElement == null) {
			if (other.parentElement != null)
				return false;
		} else if (!parentElement.equals(other.parentElement))
			return false;
		return true;
	}

	@Override
	public int compareTo(Field o) {
		return o.getFieldName().compareTo(this.getFieldName());
	}

	@Override
	public String toString() {
		return "Field [fieldName=" + fieldName + ", hasSon=" + hasSon+ ", isMultiple=" + isMultiple + "]";
	}
	
	

}
