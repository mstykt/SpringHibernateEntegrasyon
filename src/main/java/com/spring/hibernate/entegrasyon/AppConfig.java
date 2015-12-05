package com.spring.hibernate.entegrasyon;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.spring.hibernate.entegrasyon")
@EnableTransactionManagement
@PropertySource(value={"connection/dbConnection.properties"})
public class AppConfig {
	@Autowired
	Environment environment;
	
	@Bean
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("driverClassName"));
		dataSource.setUrl(environment.getProperty("url"));
		dataSource.setUsername(environment.getProperty("username"));
		dataSource.setPassword(environment.getProperty("password"));
		return dataSource;
	}
	
	@Autowired
	@Bean
	public SessionFactory sessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.scanPackages("com.spring.hibernate.entegrasyon");
		builder.addProperties(hibernateProperties());
		return builder.buildSessionFactory();
	}
	
	@Autowired
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	private Properties hibernateProperties(){
		Properties properties=new Properties();
		properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.default_schema", environment.getProperty("hibernate.default_schema"));
		return properties;
	}
}
