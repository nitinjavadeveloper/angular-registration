package org.learn.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "users", indexes = { @Index(name = "email", columnList = "email", unique = true), })
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;

	private String empName;
	private String email;
	private String password;
	private String description;
	private String designation;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Users(int empId, String empName, String email, String password, String description, String designation) {
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.password = password;
		this.description = description;
		this.designation = designation;
	}

	public Users() {

	}

	public Users(String password) {
		
		this.password = password;
	}

}
