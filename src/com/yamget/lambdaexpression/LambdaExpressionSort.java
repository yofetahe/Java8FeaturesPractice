package com.yamget.lambdaexpression;

import java.util.Arrays;

public class LambdaExpressionSort {

	public static void main(String[] args) {
		
		Animal[] animalArr = {
				new Animal("Lion"),
				new Animal("Elephant"),
				new Animal("Cat")
			};
		
		System.out.println("Before Sorting: " + Arrays.toString(animalArr));
		
		Arrays.sort(animalArr, Animal::animalCompare);
		
		System.out.println("After Sorting: " + Arrays.deepToString(animalArr));
	}	
}

class Animal {
	
	private String name;
	
	Animal(String name){
		this.name = name;
	}
	
	public static int animalCompare(Animal a1, Animal a2) {
		return a1.name.compareTo(a2.name);
	}
	
	public String toString() {
		return name;
	}
}