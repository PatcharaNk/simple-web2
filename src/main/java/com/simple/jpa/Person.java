package com.simple.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: customer
 *
 */
@Entity
@Table(name = "persons")
public class Person implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID" ,unique = true)
	private int id;
	
	@Column(name = "Firstname" , nullable = false)
	private String firstname;
	
	@Column(name = "Lastname" , nullable = false)
	private String lastname;
	
	@Column(name = "Age")
	private int age;
	
	@Column(name = "Sex")
	private String sex;
	
	@Column(name = "PhoneNumber")
	private String phone;
	
	public Person() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	@Override
	public String toString() {
		return "Person: "+id+","+firstname+"  "+lastname+","+age+","+sex+","+phone;
	}
   
}
