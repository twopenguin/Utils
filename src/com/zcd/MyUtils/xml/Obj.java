package com.zcd.MyUtils.xml;

import java.util.List;
import java.util.TreeSet;

public class Obj implements Comparable<Obj>{

	private String objName;
	
	private TreeSet<Field> fields;
	
	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public TreeSet<Field> getFields() {
		return fields;
	}

	public void setFields(TreeSet<Field> fields) {
		this.fields = fields;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
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
		Obj other = (Obj) obj;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		return true;
	}

	@Override
	public int compareTo(Obj o) {
		return o.getObjName().compareTo(this.getObjName());
	}

	@Override
	public String toString() {
		return "Obj [objName=" + objName + ", fields=" + fields + "]";
	}
	
	
	
	
	
	
	
}
