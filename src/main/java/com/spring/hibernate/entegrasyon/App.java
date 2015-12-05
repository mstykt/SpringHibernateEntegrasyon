package com.spring.hibernate.entegrasyon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		Personel personel=new Personel();
		personel.setName("Personel Name");
		personel.setSurname("Personel Surname");
		personel.setCity("Personel City");
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		PersonelController pcontroller=context.getBean(PersonelController.class);
		pcontroller.create(personel);
		context.close();

	}

}
