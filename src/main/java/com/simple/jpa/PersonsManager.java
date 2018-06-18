package com.simple.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.jandex.Main;

public class PersonsManager {
	static EntityManagerFactory factory;
	static EntityManager entityManager;
	
	public static void main(String[] arge) {
		begin();
		
		//create();
		//update();
		find();
		
		end();
		
	}

	private static void end() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

	private static void begin() {
		factory = Persistence.createEntityManagerFactory("PersonUnit");
		entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
	}

	private static void create() {
		Person newPerson = new Person();
		newPerson.setFirstname("Patcha");
		newPerson.setLastname("Nak");
		newPerson.setAge(50);
		newPerson.setPhone("0812345678");
		newPerson.setSex("m");
		
		entityManager.persist(newPerson);
	}
	
	private static void update() {
		Person exitsPerson = new Person();
		exitsPerson.setId(3);
		exitsPerson.setFirstname("Bell");
		exitsPerson.setLastname("LLeb");
		exitsPerson.setAge(11);
		exitsPerson.setPhone("0812345111");
		exitsPerson.setSex("f");
		
		entityManager.merge(exitsPerson);
	}
	
	private static void find() {
		Integer primaryKey = 3;
		Person person = entityManager.find(Person.class, primaryKey);
		
		System.out.println(person.toString());
	}

}
