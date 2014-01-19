package com.website.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class ListUtil {

	public static List copy(List master) {
		if (master == null) {
			return null;
		}

		return new ArrayList(master);
	}

	public static void copy(List master, List copy) {
		if ((master == null) || (copy == null)) {
			return;
		}

		copy.clear();

		Iterator itr = master.iterator();

		while (itr.hasNext()) {
			Object obj = itr.next();

			copy.add(obj);
		}
	}

	public static void distinct(List list) {
		distinct(list, null);
	}

	public static void distinct(List list, Comparator comparator) {
		if ((list == null) || (list.size() == 0)) {
			return;
		}

		Set<Object> set = null;

		if (comparator == null) {
			set = new TreeSet<Object>();
		}
		else {
			set = new TreeSet<Object>(comparator);
		}

		Iterator<Object> itr = list.iterator();

		while (itr.hasNext()) {
			Object obj = itr.next();

			if (set.contains(obj)) {
				itr.remove();
			}
			else {
				set.add(obj);
			}
		}
	}

	public static List fromArray(Object[] array) {
		if ((array == null) || (array.length == 0)) {
			return new ArrayList();
		}

		List list = new ArrayList(array.length);

		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}

		return list;
	}

	public static List fromCollection(Collection c) {
		if ((c != null) && (c instanceof List)) {
			return (List)c;
		}

		if ((c == null) || (c.size() == 0)) {
			return new ArrayList();
		}

		List list = new ArrayList(c.size());

		Iterator itr = c.iterator();

		while (itr.hasNext()) {
			list.add(itr.next());
		}

		return list;
	}

	public static List fromEnumeration(Enumeration enu) {
		List list = new ArrayList();

		while (enu.hasMoreElements()) {
			Object obj = enu.nextElement();

			list.add(obj);
		}

		return list;
	}

	public static List fromFile(String fileName) throws IOException {
		return fromFile(new File(fileName));
	}

	public static List fromFile(File file) throws IOException {
		List list = new ArrayList();

		BufferedReader br = new BufferedReader(new FileReader(file));

		String s = StringPool.BLANK;

		while ((s = br.readLine()) != null) {
			list.add(s);
		}

		br.close();

		return list;
	}

	public static List fromString(String s) {
		return fromArray(StringUtils.split(s, StringPool.NEW_LINE));
	}



	public static List subList(List list, int start, int end) {
		List newList = new ArrayList();

		int normalizedSize = list.size() - 1;

		if ((start < 0) || (start > normalizedSize) || (end < 0) ||
			(start > end)) {

			return newList;
		}

		for (int i = start; i < end && i <= normalizedSize; i++) {
			newList.add(list.get(i));
		}

		return newList;
	}

	public static List<Boolean> toList(boolean[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Boolean> list = new ArrayList<Boolean>(array.length);

		for (boolean value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<Double> toList(double[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Double> list = new ArrayList<Double>(array.length);

		for (double value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<Float> toList(float[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Float> list = new ArrayList<Float>(array.length);

		for (float value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<Integer> toList(int[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Integer> list = new ArrayList<Integer>(array.length);

		for (int value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<Long> toList(long[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Long> list = new ArrayList<Long>(array.length);

		for (long value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<Short> toList(short[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Short> list = new ArrayList<Short>(array.length);

		for (short value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<Boolean> toList(Boolean[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Boolean> list = new ArrayList<Boolean>(array.length);

		for (Boolean value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<Double> toList(Double[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Double> list = new ArrayList<Double>(array.length);

		for (Double value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<Float> toList(Float[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Float> list = new ArrayList<Float>(array.length);

		for (Float value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<Integer> toList(Integer[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Integer> list = new ArrayList<Integer>(array.length);

		for (Integer value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<Long> toList(Long[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Long> list = new ArrayList<Long>(array.length);

		for (Long value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<Short> toList(Short[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<Short> list = new ArrayList<Short>(array.length);

		for (Short value : array) {
			list.add(value);
		}

		return list;
	}

	public static List<String> toList(String[] array) {
		if ((array == null) || (array.length == 0)) {
			return Collections.EMPTY_LIST;
		}

		List<String> list = new ArrayList<String>(array.length);

		for (String value : array) {
			list.add(value);
		}

		return list;
	}

	public static String toString(List list,String param) {
		return toString(list,param,StringPool.COMMA);
	}

	public static String toString(List list,String param, String delimiter) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			
			Object value = list.get(i);

			if (value == null) {
				value = StringPool.BLANK;
			}

			sb.append(value.toString());

			if ((i + 1) != list.size()) {
				sb.append(delimiter);
			}
		}

		return sb.toString();
	}

	/***
	 * 两个集合交集
	 * @Name: ListUtil.java
	 * @Description: TODO
	 * @author: wang_chian@foxmail.com
	 * @version: Jun 6, 2012 2:39:32 PM 
	 * @param lista
	 * @param listb
	 * @return
	 */
	public static List UniteList(List x,List y){
		if ((x == null) || (x.size() == 0) || (y == null) || (y.size() == 0)) {
			return new ArrayList();
		}
		if(x.size()>y.size()){
		   x.retainAll(y); 
		   return x;
		}else{
		   y.retainAll(x); 
		   return y;
		}
	}
	
	/***
	 * 多个集合交集
	 * @Name: ListUtil.java
	 * @Description: TODO
	 * @author: wang_chian@foxmail.com
	 * @version: Jun 6, 2012 5:25:26 PM 
	 * @param x
	 * @param y
	 * @return
	 */
	public static List UniteLists(List x,List y){
		List list = new ArrayList();
		
		if(x.size()>y.size()){
		   for(int i =0;i<x.size();i++){
		       if(!y.contains(x.get(i))){
		    	  x.remove(x.get(i));
		       }else{
		    	  list.add(x.get(i));  
		       }
		    }
		}else{
		   for(int i =0;i<y.size();i++){
		      if(!x.contains(y.get(i))){
		    	  y.remove(y.get(i));
		       }else{
		    	  list.add(y.get(i));  
		       }
		    } 
	      }
		return list;
	}
	
	
	
	
	/***
	 * 并集
	 * @Name: ListUtil.java
	 * @Description: TODO
	 * @author: wang_chian@foxmail.com
	 * @version: Jun 6, 2012 2:39:43 PM 
	 * @param lista
	 * @param listb
	 * @return
	 */
	public static List MergeList(List x,List y){
		
		if(x.size()>y.size()){
			for(int i =0;i<x.size();i++)
			  {
			     if(!y.contains(x.get(i))){
			    	 y.add(x.get(i));
			     }
			  }
			return y;
		}else{
			for(int i =0;i<y.size();i++)
			  {
			     if(!x.contains(y.get(i))){
			    	 x.add(y.get(i));
			     }
			  }
			return x;
		}
		
	}
	
	
	
}