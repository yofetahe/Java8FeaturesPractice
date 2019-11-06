package com.yamget.lambdaexpression;

public class InterfaceImplementation {
	
	interface HelloWorld {
		String hello(String value);
	}
	
	public static void main(String[] args) {
		
		HelloWorld helloWorld = (String name) -> "Hello " + name;
		
		System.out.println(helloWorld.hello("TEST"));
	}
}
