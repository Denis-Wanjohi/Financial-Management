package com.Final.bean;

public class Student {

	public int id;
	public String firstname;
	public String secondname;
	public int identification_number;
	public String programme ;
	public String registration_number;
	public String gender;
	public String email;
	public String password;
	public int phone_number;
	
	
	

	public Student(String firstname, String secondname, int identification_number, String programme,
			String registration_number, String gender, String email, String password, int phone_number) {
		super();
		this.firstname = firstname;
		this.secondname = secondname;
		this.identification_number = identification_number;
		this.programme = programme;
		this.registration_number = registration_number;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
	}
	
	



	public Student(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}





	public Student(int id, String firstname, String secondname, int identification_number, String programme,
			String registration_number, String gender, String email, String password, int phone_number) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.secondname = secondname;
		this.identification_number = identification_number;
		this.programme = programme;
		this.registration_number = registration_number;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
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




	public String getSecondname() {
		return secondname;
	}




	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}




	public int getIdentification_number() {
		return identification_number;
	}




	public void setIdentification_number(int identification_number) {
		this.identification_number = identification_number;
	}




	public String getProgramme() {
		return programme;
	}




	public void setProgramme(String programme) {
		this.programme = programme;
	}




	public String getRegistration_number() {
		return registration_number;
	}




	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
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




	public int getPhone_number() {
		return phone_number;
	}




	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}




	public Student() {
		// TODO Auto-generated constructor stub
	}

}
