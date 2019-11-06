package com.yamget.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {
	/*
	 * Stream Pipeline ---> divided into two ---> Intermediate and Terminal operations
	 * 
	 * Intermediate Operation ---> further divided into ---> Stateless and Stateful operations
	 * 		* Stateless - like filter or map --> don't retain state from previously seen elements when processing a new element 										 
	 * 		* Statefull - like distinct and sorted --> incorporate state from previously seen elements when processing a new element
	 * 											   --> need to process the entire input before producing a result
	 * 
	 * Methods
	 * 		static - builder, empty, generate, iterate, of (2 cases)
	 * 
	 * 		allMatch, anyMatch, noneMatch, 		
	 * 		concat ????, 
	 * 		count, distinct, limit, max, min, peek, 		
	 * 		findAny, findFirst, 
	 * 		flatMap, flatMapToDouble, flatMapToInt, flatMapToLong, 
	 * 		filter, collect (2 cases),  
	 * 		forEach, forEachOrdered, 
	 * 		map, mapToDouble, mapToInt, mapToLong, 
	 * 		reduce (3 cases),
	 * 		skip, sorted (2 cases), toArray (2 cases)
	 */

	public static void main(String[] args) {
		
		String[] values = {"one", "two", "three", "one"};		
		List<String> v = Arrays.asList(values);
		
		//AnyMatch
		boolean anyMatch = v.stream().anyMatch(c -> c.startsWith("t"));
		System.out.println(anyMatch);
		
		//Count
		long size = v.stream().count();
		System.out.println(size);
		
		//Distinct
		Stream<String> discinctRslt = v.stream().distinct();
		System.out.println(discinctRslt.count());
		
		//Limit
		Stream<String> limitRslt = v.stream().limit(2);
		System.out.println(limitRslt.count());
		
		//Max
		Comparator<String> maxLen = Comparator.comparing(String::length);
		Optional<String> longestStr = v.stream().max(maxLen);
		System.out.println(longestStr.get());
		
		Optional<String> findFirst = v.stream().findFirst();
		System.out.println(findFirst.get());
		
		//filter and collect
		List<String> filterCollectRslt = v.stream().filter(c -> {
			return c.startsWith("o");
		}).collect(Collectors.toList());
		System.out.println(filterCollectRslt);
		
		//Collect
		List<String> collectRslt = v.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(collectRslt);
		
		// ToArray
		Object[] arrayRslt = v.stream().toArray();
		System.out.println(arrayRslt);
		
		// Reduce
		Optional<String> reduceRslt = v.stream().reduce((a1, a2) -> a1 + " | " + a2);
		System.out.println(reduceRslt.get());
		
		
		////>>>> Concatenate two arrays ---> flatMap & concat
		Integer[] array1 = {1,2,3,4};
		Integer[] array2 = {5,6,7,8};
		
		Integer[] rs1 = Stream.of(array1, array2).flatMap(Stream::of).toArray(Integer[]::new);
		Arrays.asList(rs1).stream().forEach(c -> System.out.println(c));
		
		Integer[] rs2 = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(Integer[]::new);
		Arrays.asList(rs2).stream().forEach(c -> System.out.println(c));
	}

}
