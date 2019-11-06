package com.yamget.functionalInterface;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces {
	
	@FunctionalInterface
	public interface Calculate{
		public void calc(int a, int b);
	}

	public static void main(String[] args) {
		
		// User defined functionalInterface
		Calculate add = (a, b) -> System.out.println(a+b);
		Calculate multiply = (a, b) -> System.out.println(a*b);
		
		add.calc(3, 5);
		multiply.calc(3, 5);
				
		//>>>> Predicate - takes one argument, returns a boolean
		Predicate<String> stringLen = (s) -> s.length() < 10;
		System.out.println(stringLen.test("TEST"));
		
		Predicate<Integer> checkValue = (i) -> i > 10;
		System.out.println(checkValue.test(5));
		
		//>>>> Consumer - accepts single argument with no return value
		Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
		consumerStr.accept("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		Consumer<String> consumerStr2 = System.out::println;
		consumerStr2.accept("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		//>>>> Function - accepts one argument and produces a result
		//<xxx, yyy> ---> xxx is argument, yyy is return value
		Function<String, Integer> converter = (num) -> num.substring(num.length()/2).length();
		System.out.println(converter.apply("2665897"));
		
		//>>>> Supplier - represents a supplier of results. Why it is used for????
		Supplier<String> s = () -> "Java 8 Supplier";
		System.out.println(s.get());
		
		//>>>> Binary Operator - takes two arguments and returns one
		BinaryOperator<String> concat = (a, b) -> a + b;
		System.out.println(concat.apply("Binary", "Operator"));
		
		//>>>> Unary Operator - single argument with a return value
		UnaryOperator<String> str = (msg) -> msg.toUpperCase();
		System.out.println(str.apply("this is lowercase"));
	}

}
