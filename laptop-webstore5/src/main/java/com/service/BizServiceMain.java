package com.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BizServiceMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("biz-service.xml");
		//why case here??
		BizService bizservice = (BizService)context.getBean("biza");
		Biz biz = new Biz();
		biz.setId(0);
		biz.setName("Ford");
		biz.setBrand("Mustang");
		Timestamp timestamp = new Timestamp(new Date().getTime()); 
		biz.setDoe(timestamp);
		
		bizservice.save(biz);
		
		System.out.println("JUST SAVED ITEMS: ");
		List<Biz> bizitems = bizservice.findAll();
		for(Biz bizs : bizitems) {
			System.out.println(bizs);
		}
	}
}
