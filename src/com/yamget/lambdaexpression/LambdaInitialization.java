package com.yamget.lambdaexpression;

import java.util.concurrent.Callable;

public class LambdaInitialization {

	public static void main(String[] args) throws Exception {
		
		Callable[] animals = new Callable[] {() -> "Lion"};
		
		System.out.println(animals[0].call());
	}

}
