	package com.Final.bean;

public class Staff {
	
	public int id;
	public String name;
	public String staff_number;
	public String identification_number;
	public String email;
	public String password;
	public String gender;
	public String phone_number;
	public Boolean isAdmin;
	
	
	
	
	
	public Staff(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	



	public Staff(int id, String name, String staff_number, String identification_number, String email, String password,
			String gender, String phone_number, Boolean isAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.staff_number = staff_number;
		this.identification_number = identification_number;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.phone_number = phone_number;
		this.isAdmin = isAdmin;
	}
	
	
	




	public Staff(String name, String staff_number, String identification_number, String email, String password,
			String gender, String phone_number, Boolean isAdmin) {
		super();
		this.name = name;
		this.staff_number = staff_number;
		this.identification_number = identification_number;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.phone_number = phone_number;
		this.isAdmin = isAdmin;
	}
	
	



	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getStaff_number() {
		return staff_number;
	}




	public void setStaff_number(String staff_number) {
		this.staff_number = staff_number;
	}




	public String getIdentification_number() {
		return identification_number;
	}




	public void setIdentification_number(String identification_number) {
		this.identification_number = identification_number;
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




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getPhone_number() {
		return phone_number;
	}




	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}




	public Boolean getIsAdmin() {
		return isAdmin;
	}




	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}




	public Staff() {
		// TODO Auto-generated constructor stub
	}

}
