package mule.lang;

import java.util.ArrayList;
import java.util.function.Function;

import mule.util.Util;

public class Lists {
	
	public static <T> Boolean isEmpty(ArrayList<T> list) {
		return list.isEmpty();
	}
	
	public static <T> Integer lengthOf(ArrayList<T> list) {
		return list.size();
	}	
	
	public static <T> Integer indexOf(ArrayList<T> list, T elem) {
		return list.indexOf(elem);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList append(ArrayList list, Object elem){
		ArrayList result = new ArrayList();
		result.addAll(list);
		if(elem instanceof ArrayList)			
			result.addAll((ArrayList)elem);
		else result.add(elem);
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList prepend(ArrayList list, Object elem){
		ArrayList result = new ArrayList();
		if(elem instanceof ArrayList)			
			result.addAll((ArrayList)elem);
		else result.add(elem);
		result.addAll(list);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean contains(ArrayList list, Object elem) {
		return list.contains(elem);
	}
	
	public static <T> T head(ArrayList<T> list){
		if(list.get(0) != null)
			return list.get(0);
		return null;
	}
	
	public static <T> ArrayList<T> tail(ArrayList<T> list){
		ArrayList<T> result = new ArrayList<T>();
		if(list.size() > 1)
			for(int i = 1; i < list.size(); i++)
				result.add(list.get(i));
		return result;
	}
	
	public static <T> T last(ArrayList<T> list){
		T last = (T) list.get(list.size()-1);
		return last;		
	}
    
	public static <T> ArrayList<T> subList(ArrayList<T> list, Integer min, Integer max){
		ArrayList<T> result = new ArrayList<T>();
//		if(min >= 0 && max < list.size()){
			for(int i = min; i <= max; i++)
				result.add(list.get(i));
//		}
		return result;
	}
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList insert(ArrayList list, Object elem, Integer pos){
		ArrayList result = new ArrayList();
		for(Object o : list)
			result.add(o);
		if(elem instanceof ArrayList)			
			result.addAll(pos, (ArrayList)elem);
		else result.add(pos, elem);
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList removeElement(ArrayList list, Object elem){
		ArrayList result = new ArrayList();
		result.addAll(list);
//		ArrayList<T> result = list;
		if(elem instanceof ArrayList)
			result.removeAll((ArrayList)elem);
		else result.remove(elem);
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList removePosition(ArrayList list, Integer pos){
		ArrayList result = new ArrayList();
		result.addAll(list);
		int p = pos;
		result.remove(p);
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void forEach(ArrayList list, Function<Object, Object> f) {
		ArrayList result = new ArrayList();
		result.addAll(list);
		for (Object obj : result) {
			f.apply(obj);
		}
	}

	public static <T> ArrayList<T> filter(ArrayList<T> list, Function<T, Boolean> f){
		ArrayList<T> result = new ArrayList<>();
		for (T obj : list) {
			if (f.apply(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

}
