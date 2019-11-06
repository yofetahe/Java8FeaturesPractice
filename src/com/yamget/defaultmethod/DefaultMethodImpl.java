package com.yamget.defaultmethod;

public class DefaultMethodImpl implements Animal {
	
	public static void main(String[] args) {
		
		DefaultMethodImpl a = new DefaultMethodImpl();
		a.animalColor();
		a.animalSound("meaw");
	}
	
//	public void animalSound(String sound) {
//		System.out.println("my Sound is " + sound);
//	}

}

interface Animal{
	
	default void animalSound(String sound) {
		System.out.println("my default Sound is " + sound);
	}
	
	default void animalColor() {
		System.out.println("color");
	}
}
