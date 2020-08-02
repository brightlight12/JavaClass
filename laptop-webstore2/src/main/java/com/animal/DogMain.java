package com.animal;

public class DogMain {

	public static void main(String[] args) {
		
		//who is creating instance of Dog? Programmer
		Dog dog = new Dog();
		//who is setting the state of the Dog? Programmer
		dog.setColor("White");
		dog.setName("Tommy");
		dog.setTail(2);
		
		String result = dog.toString();
		System.out.println(result);
		//who is killing the Dog? Programmer
		dog=null;
		}

}
