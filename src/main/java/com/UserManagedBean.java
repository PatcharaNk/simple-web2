package com;



import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mysql.cj.xdevapi.Statement;
import com.simple.jpa.Person;

@Named
@RequestScoped

public class UserManagedBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Size(min=2, max=50)
	private String firstname;
	@NotNull
	@Size(min=2, max=50)
	private String lastname;
	@NotNull
	@Size(max=2)
	private String sex;
	@NotNull
	@Max(150)
	private Integer age;
	@NotNull
	@Size(min=10, max=10)
	private String phone;



	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean save() {
		int result = 0;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simpledb", "root", "0867633573");
//			PreparedStatement stmt = con.prepareStatement("insert into persons(Firstname, Lastname, Age, Sex, PhoneNumber) value(?, ?, ?, ?, ?)");
//			stmt.setString(1, this.getFirstname());
//			stmt.setString(2, this.getLastname());
//			stmt.setInt(3, this.getAge());
//			stmt.setString(4, this.getSex());
//			stmt.setString(5, this.getPhone());
//			result = stmt.executeUpdate();
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersonUnit");
			EntityManager entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();
			
			
			Person newPerson = new Person();
			newPerson.setFirstname(this.getFirstname());
			newPerson.setLastname(this.getLastname());
			newPerson.setAge(this.getAge());
			newPerson.setPhone(this.getPhone());
			newPerson.setSex(this.getSex());
			entityManager.persist(newPerson);
			result = 1;
			
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		if(result == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public String submit() {
		if(this.save()) {
			return "response.xhtml";
		}else {
			return "....";
		}
	}
	
	public List<Person> allPersons() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersonUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		
		String jpql = "SELECT p FROM Person p";
		javax.persistence.Query q = entityManager.createQuery(jpql);
		
		@SuppressWarnings("unchecked")
		List<Person> listPersons = q.getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
		
		return listPersons;
	}
	
}
