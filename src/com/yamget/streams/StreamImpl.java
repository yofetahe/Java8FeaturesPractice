package com.yamget.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamImpl {

	public static void main(String[] args) {

		///// Example 1
		Stream.of("Apple", "Banana", "Avocado", "Pear").filter((String fruit) -> {
			System.out.println("f : " + fruit);
			return fruit.startsWith("A");
		}).forEach(fruit -> System.out.println("Result >>> " + fruit));

		///// Example 2
		// Stream<Date> dates = Stream.generate(() -> { return new Date();});
		// dates.forEach(d -> System.out.println(d));

		///// Example 3
		// IntStream values = "123654_abcde".chars();
		// values.forEach(v -> System.out.println(v));

		// ====================CONVERT STREAM TO COLLECTIONS====================//
		// 1. TO LIST
		List<Integer> c = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		List<Integer> filtered_c = c.stream().filter(v -> v % 2 == 0).collect(Collectors.toList());
		System.out.println(filtered_c.toString());

		Integer[] array_c = c.stream().filter(v -> v % 2 != 0).toArray(Integer[]::new);
		System.out.println(array_c);

		// Sort Example
		ArrayList<String> names = new ArrayList<String>(Arrays.asList("test", "abc", "kBI", "axy"));
		Collections.sort(names, (a, b) -> a.compareTo(b));
		System.out.println(names.toString());

		// ===================Intermediate and Terminal Operations================//
		// Intermediate - filtered, sorted, map, flatMap, distinct, peek, limit, skip
		List<String> names2 = names.stream().filter(x -> x.startsWith("a")).sorted().map(x -> "hi " + x)
				.collect(Collectors.toList());
		System.out.println(names2.toString());
		

		// Terminal - forEach, forEachOrdered, toArray, collect, match(anyMatch, allMatch, noneMatch), count, min, max, reduce, findFirst, findAny
		boolean match_result = names.stream().anyMatch(v -> v.startsWith("a"));
		System.out.println(match_result);
		
		System.out.println(names.stream().count());
		
		Optional<String> reduced = names.stream()
				.reduce((a1, a2) -> a1+ "#" + a2);
		reduced.ifPresent(System.out::println);
		System.out.println(reduced);
		
		String firstResult = names.stream().filter(v -> v.startsWith("a")).findFirst().get();
		System.out.println(firstResult);
		

		
		
		
		Collection<Integer> test = new HashSet<Integer>(Arrays.asList(5, 5, 4, 4, 4, 3, 2, 1, 1, 1));
		System.out.println(test.toString());

		Set<Integer> test2 = new HashSet<Integer>(Arrays.asList(5, 5, 4, 4, 4, 3, 2, 1, 1, 1));
		System.out.println(test2.toString());
	}

}
