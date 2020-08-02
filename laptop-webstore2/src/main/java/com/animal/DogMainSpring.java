package com.animal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogMainSpring {
	
	public static void main(String[] args) {
		//creating spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("dogs.xml");
		Dog d1 = (Dog)context.getBean("dog");
		System.out.println(d1);
		Dog d2 = (Dog)context.getBean("magicDog");
		d2 = null;
		
		d2 = (Dog)context.getBean("magicDog");
		System.out.println(d2);
	}

}
