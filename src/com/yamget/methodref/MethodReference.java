package com.yamget.methodref;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MethodReference {

	public static void main(String[] args) {
		
		//=====Type of method reference=====//
		
		//1. Reference to STATIC method ---> Math::max <=> Math.max(x,y)
		List<Integer> integers = new ArrayList<Integer>(Arrays.asList(1,2,5,8,9,4,3));
		Optional<Integer> max_int = integers.stream().reduce(Math::max);
		max_int.ifPresent(v -> System.out.println(v));
		
		//2. Reference to INSTANCE method from INSTANCE ---> System.out::println <=> System.out.println(x)
		max_int.ifPresent(System.out::println);
		
		//3. Reference to INSTANCE method from CLASS type ---> String::length <=> str.length()
		List<String> sorted_1 = Stream.of("abc", "kez", "yth", "lms").sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
		List<String> sorted_2 = Stream.of("abc", "kez", "yth", "lms").sorted(String::compareTo).collect(Collectors.toList());
		System.out.println(sorted_2);
		
		//4. Reference to CONSTRUCTOR ---> ArrayList::new <=> new ArrayList()
		List<Integer> value = IntStream.range(1, 20).boxed().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(value.toString());
		
		//=================================//
		
		
		IntFunction<String> intToString = num -> Integer.toString(num);
		System.out.println(intToString.apply(123).length());
		
		//>>>> static method reference using ::
		IntFunction<String> intToString2 = Integer::toString;
		System.out.println(intToString2.apply(123));
		
		//>>>> lambdas made using a constructor
		Function<String, BigInteger> newBigInt = BigInteger::new;
		System.out.println(newBigInt.apply("147852"));
		
		//>>>> example of a lambda made from an instance method
		Consumer<Integer> print = System.out::println;
		print.accept(147852369);
		
		
		UnaryOperator<String> makeGreeting = "Hello, "::concat;
		System.out.println(makeGreeting.apply("Sir"));
		
		
	}

}
