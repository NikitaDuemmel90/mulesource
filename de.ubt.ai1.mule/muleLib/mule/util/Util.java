package mule.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

import de.ubt.ai1.mule.muLE.Attribute;
import de.ubt.ai1.mule.muLE.DeclaredType;
import de.ubt.ai1.mule.muLE.Composition;
import de.ubt.ai1.mule.muLE.DataType;

@SuppressWarnings("all")
public class Util {

	public static ArrayList<Integer> fillListRange(Integer min, Integer max) {
		ArrayList<Integer> list = new ArrayList<>();
		if (min instanceof Integer && max instanceof Integer) {
			for (Integer i = (Integer) min; i <= (Integer) max; i++) {
				list.add(i);
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> fillListRepetition(Integer count, T obj, String targetClassName) {
		ArrayList<T> list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			Object clone = copyObject(obj, targetClassName);
			list.add((T) clone);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> T copyObjectDeep(T objSource) {
		T objDest = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(objSource);
			oos.flush();
			oos.close();
			bos.close();
			byte[] byteData = bos.toByteArray();
			ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
			try {
				objDest = (T) new ObjectInputStream(bais).readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objDest;
	}

	public static <T> T copyObject(T objSource, String targetClassName) {
		if (objSource == null) {
			return null;
		}
		if (objSource instanceof MuLEReferenceType<?>) {
//			MuLEReferenceType newRef = new MuLEReferenceType(((MuLEReferenceType)objSource).value);
//			return (T) newRef;
			return objSource;
		} else if (objSource instanceof Function || objSource instanceof Supplier) {
			return objSource;
		} else if (objSource instanceof ArrayList) {
			ArrayList<Object> result = new ArrayList<>();
			for (Object value : (ArrayList<Object>) objSource) {
				if (value == null) {
					result.add(null);
				} else {
					targetClassName = targetClassName.replaceFirst("ArrayList<", "").replaceFirst(">", "");
//					Class<? extends Object> valueClazz = value.getClass();
//					String valueClassName = valueClazz.getTypeName();
					Object valueCopy = copyObject(value, targetClassName);
					result.add(valueCopy);
				}
			}
			return (T) result;
		} else if (objSource instanceof Integer) {
			return objSource;
		} else if (objSource instanceof Double) {
			return objSource;
		} else if (objSource instanceof String) {
			return objSource;
		} else if (objSource instanceof Boolean) {
			return objSource;
		} else {
			Class<? extends Object> clazz = objSource.getClass(); // get the class of the source object
//			System.out.println(targetClassName);
			try {
//				System.out.println("trying");
				clazz = Class.forName(targetClassName); // try to get the target class
			} catch (ClassNotFoundException e) {
//				System.out.println("didnt work");	// well, we tried, we still have the source class
			} catch (NullPointerException e) {
//				System.out.println("was a null reference");
			}
			if (clazz.isEnum()) {
				return objSource;
			}
			try {
				Object result = clazz.newInstance();
				while (clazz != null) {
					for (Field field : clazz.getDeclaredFields()) {
						if(!field.getName().equals("serialVersionUID"))
							field.setAccessible(true);
						Object value = field.get(objSource);
						if (value != null) {
							Class<? extends Object> valueClazz = value.getClass();
							String valueClassName = valueClazz.getTypeName();
							value = copyObject(value, valueClassName);
							field.set(result, value);
						} else {
							field.set(result, null);
						}
					}
					clazz = clazz.getSuperclass();
				}
				return (T) result;
			} catch (InstantiationException | IllegalAccessException e) {
//				e.printStackTrace();
			}
			return objSource;
		}
	}

	public static boolean MuLEEquals(Object left, Object right) {
		// compare null references
		if (left == null) {
			return right == null;
		}
		if (right == null) {
			return left == null;
		}
		// type based comparison
		Class cLeft = left.getClass();
		Class cRight = right.getClass();
		// compare references
		if (cLeft.equals(MuLEReferenceType.class) && cRight.equals(MuLEReferenceType.class)) {
			return left == right;
		}
		// compare numeric types
		if (left instanceof Integer && right instanceof Double) {
			return new Double((Integer)left).equals(new Double((Double) right));
		}
		if (left instanceof Double && right instanceof Integer) {
			return new Double((Double)left).equals(new Double((Integer) right));
		}
		// compare other basic types
		if (left instanceof String && right instanceof String || left instanceof Boolean && right instanceof Boolean) {
			return left.equals(right);
		}
		// compare lists
		if (left instanceof ArrayList && right instanceof ArrayList) {
			ArrayList lLeft = (ArrayList) left;
			ArrayList lRight = (ArrayList) right;
			if (lLeft.size() != lRight.size()) {
				return false;
			}
			for (int i = 0; i < lLeft.size(); i++) {
				if (!MuLEEquals(lLeft.get(i), lRight.get(i))) {
					return false;
				}
			}
		}
		// compare complex types
		boolean leftSubtypeOfRight = false;
		boolean rightSubtypeOfLeft = false;
		Class cLeftTemp = cLeft;
		Class cRightTemp = cRight;
		while (cLeftTemp != null) {
			if (cLeftTemp.equals(cRight)) {
				leftSubtypeOfRight = true;
				break;
			}
			cLeftTemp = cLeftTemp.getSuperclass();
		}
		while (!leftSubtypeOfRight && cRightTemp != null) {
			if (cRightTemp.equals(cLeft)) {
				rightSubtypeOfLeft = true;
				break;
			}
			cRightTemp = cRightTemp.getSuperclass();
		}

		if (!leftSubtypeOfRight && !rightSubtypeOfLeft) {
			return false;
		} else {
			if (leftSubtypeOfRight) {
				return right.equals(left);
			} else {
				return left.equals(right);
			}
		}
	}

	public static ArrayList<Attribute> getListOfPublicAttributesInInheritanceRelation(Composition c) {
		ArrayList<Attribute> _list = new ArrayList<Attribute>();
		for (Attribute attr : c.getAttributes()) {
//			if (attr.getVisibility() == null) {
			_list.add(attr);
//			}
		}
		Composition superType = c.getSuperType();
		while (superType != null) {
			int index = 0;
			for (Attribute attr : superType.getAttributes()) {
//				if (attr.getVisibility() == null) {
				_list.add(index, attr);
				index++;
//				}
			}
			superType = superType.getSuperType();
		}
		return _list;
	}
}
