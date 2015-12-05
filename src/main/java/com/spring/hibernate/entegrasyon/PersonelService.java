package com.spring.hibernate.entegrasyon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonelService {
	@Autowired
	private PersonelDAO personelDAO;
	
	public Long create(Personel personel) throws NullPointerException{
		return personelDAO.create(personel);
	}
}
