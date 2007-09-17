//--------------------------------------
// XerialJ Project
//
// CollectionUtil.java
// Since: May 8, 2007
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class CollectionUtil {
	
	
	/**
	 * Non constractable class 
	 */
	private CollectionUtil() {}
	
	public static <In> List<String> toString(Collection<In> collection)
	{
		ArrayList<String> result = new ArrayList<String>();
		for(In input : collection)
		{
			if(input != null)
				result.add(input.toString());
			else
				result.add(null);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static <In> List collectFromNonGenericCollection(Iterable collection, Functor<In> functor)
	{
		ArrayList result = new ArrayList();
		for(Iterator it = collection.iterator(); it.hasNext(); )
		{
			In input = (In) it.next();
			result.add(functor.apply(input));
		}
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <In> List<In> select(Iterable<In> collection, Predicate<In> filter)
	{
		ArrayList<In> result = new ArrayList<In>();
		for(In input : collection)
		{
			if(filter.apply(input))
				result.add(input);
		}
		return result;
	}
	

	@SuppressWarnings("unchecked")
	public static <In> List collect(Iterable<In> collection, Functor<In> functor)
	{
		ArrayList result = new ArrayList();
		for(In input : collection)
		{
			result.add(functor.apply(input));
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static <K, V> List collect(Map<K, V> map, BinaryFunctor<K, V> functor)
	{
		ArrayList result = new ArrayList();
		for(K key : map.keySet())
		{
			result.add(functor.apply(key, map.get(key)));
		}
		return result;
	}
	
	
	public static <K, V> String displayMap(Map<K, V> map, final String keyValueSeparator, final String elementSeparator)
	{
		return StringUtil.join(collect(map, new BinaryFunctor<K, V>(){
			public Object apply(K key, V value) {
				return key.toString() + keyValueSeparator + value.toString();
			}}),
			", ");
	}
	
	public static <E> TreeSet<E> sort(Collection<E> collection)
	{
		TreeSet<E> sortedSet = new TreeSet<E>();
		for(E e : collection)
		{
			sortedSet.add(e);
		}
		return sortedSet;
	}

	/**
	 * Converts an array into a list
	 * @param <E>
	 * @param array
	 * @return list representation of a given array
	 */
	public static <E> List<E> toList(E[] array) {
		ArrayList<E> result = new ArrayList<E>(array.length);
		for(int i=0; i<array.length; i++)
			result.add(array[i]);
		return result;
	}
	
}




