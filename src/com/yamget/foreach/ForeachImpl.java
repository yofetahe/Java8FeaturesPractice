package com.yamget.foreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForeachImpl {

	public static void main(String[] args) {
		
		//==== Java forEach using List ====//
		List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Consumer<Integer> action = System.out::println;
		numbers.forEach(action);
		
		//normal enhanced for loop
		for (Integer integer : numbers) {
			System.out.println(integer);
		}
	}

}
