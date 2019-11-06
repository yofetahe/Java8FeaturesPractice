package com.yamget.lambdaexpression;

public class LambdaVariableAccess {
	
	public String classAnimal = "Lion";

	public static void main(String[] args) {
		new LambdaVariableAccess().lambdaExpression();
	}
	
	public void lambdaExpression() {
		
		String localAnimal = "Tiger";
		
		new Thread(() ->  {
			System.out.println("Class Animal : " + this.classAnimal);
			System.out.println("Local Animal : " + localAnimal);
		}).start();
	}

}
