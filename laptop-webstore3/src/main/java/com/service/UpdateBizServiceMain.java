package com.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateBizServiceMain {

	public static void main(String[] args) {

		// Creating spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("biz-service.xml");
		//reading biz-service.xml and creating bean of BizService
		
		//Accessing bean of BizService type from spring container which bean name is biza
		BizService bizService=(BizService)context.getBean("biza");
		//BizService bizService2=context.getBean(BizService.class);
		
		System.out.println("All the data =");
		List<Biz> bizs=bizService.findAll();
		for(Biz pbiz:bizs){
			System.out.println(pbiz);
		}
		
		System.out.println(".......................................");
		System.out.println(".......................................");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the name to update record");
		String  name=scanner.next();
		
		System.out.println("Enter the new brand to update");
		String  brand=scanner.next();
		
		bizService.updateByName(name, brand);
		System.out.println("All the data after updating the record =");
		 bizs=bizService.findAll();
		for(Biz pbiz:bizs){
			System.out.println(pbiz);
		}
	}

}
