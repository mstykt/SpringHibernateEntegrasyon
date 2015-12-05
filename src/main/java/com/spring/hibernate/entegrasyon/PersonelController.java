package com.spring.hibernate.entegrasyon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonelController {
	@Autowired
	private PersonelService personelService;
	
	public PersonelController() {
		// TODO Auto-generated constructor stub
	}

	public PersonelService getPersonelService() {
		return personelService;
	}

	public void setPersonelService(PersonelService personelService) {
		this.personelService = personelService;
	}
	
	public void create(Personel personel) {
		personelService.create(personel);
	}
}
