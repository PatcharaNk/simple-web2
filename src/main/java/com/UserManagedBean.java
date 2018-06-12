package com;



import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(min=2, max=50)
	private String lastname;
	@Size(max=2)
	private String sex;
	@Max(150)
	private Integer age;
	@Size(min=2, max=11)
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
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simpledb", "root", "0867633573");
			PreparedStatement stmt = con.prepareStatement("insert into persons(Firstname, Lastname, Age, Sex, PhoneNumber) value(?, ?, ?, ?, ?)");
			stmt.setString(1, this.getFirstname());
			stmt.setString(2, this.getLastname());
			stmt.setInt(3, this.getAge());
			stmt.setString(4, this.getSex());
			stmt.setString(5, this.getPhone());
			result = stmt.executeUpdate();
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
	
}
