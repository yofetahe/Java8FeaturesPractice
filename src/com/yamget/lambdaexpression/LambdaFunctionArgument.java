package com.yamget.lambdaexpression;

public class LambdaFunctionArgument {

	interface Circle{
		
		double get(double radious);
	}
	
	public double circleOperation(double radious, Circle c) {
		
		return c.get(radious);
	}
	
	public static void main(String[] args) {
		
		LambdaFunctionArgument ref = new LambdaFunctionArgument();
		
		Circle circleArea = (r) -> Math.PI * r * r;
		Circle circleCircumfrance = (r) -> 2 * Math.PI * r;
		
		double area = ref.circleOperation(5, circleArea);
		double circumfracne = ref.circleOperation(5, circleCircumfrance);
		
		System.out.println("Area = " + area + ", Circumfrance = " + circumfracne);
	}
}
