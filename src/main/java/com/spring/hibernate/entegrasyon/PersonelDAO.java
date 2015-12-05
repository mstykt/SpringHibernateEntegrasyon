package com.spring.hibernate.entegrasyon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonelDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Long create(Personel personel) {
		Session session=sessionFactory.openSession();
		return (Long)session.save(personel);
	}
}
