package mule.util;

import java.io.Serializable;

public class MuLEReferenceType <T> implements Serializable {
	public T value = null;
	public MuLEReferenceType(T value) {
		this.value = value;
	}
	@Override
	public String toString() {
		String className =  value.getClass().getName();
		if (className.contains("$")) {
			className = className.split("\\$")[1];
		} else {
			className = className.replaceAll("java.lang.", "");
		}
		if (className.equals("Integer")) {
			className = "integer";
		}
		if (className.equals("Double")) {
			className = "rational";
		}
		if (className.equals("Boolean")) {
			className = "boolean";
		}
		if (className.equals("String")) {
			className = "string";
		}
//		String s = /* value +  className +*/ super.toString().split("\\$")[1];
//		s = s.replace("MuLEReferenceType", "");
		//s += " { value=" + value + " }";
		String result = super.toString().split("MuLEReferenceType")[1];
//		result = "reference<" + className + ">" + "{value = " + value + "}" + result;
		result =  value + result;
		return result;
	}
}