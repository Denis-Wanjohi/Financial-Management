package com.Final.bean;

public class ManageFinances {

	public int mess;
	public int library;
	public int salary;
	public int maintenance;
	public int games;
	public int tuition;
	public int farming;
	public int miscellenioous;
	public String month;
	public int total;
	public int year;
	
	
	
	public ManageFinances(int mess, int library, int salary, int maintenance, int games, int tuition, int farming,
			int miscellenioous, String month, int total, int year) {
		super();
		this.mess = mess;
		this.library = library;
		this.salary = salary;
		this.maintenance = maintenance;
		this.games = games;
		this.tuition = tuition;
		this.farming = farming;
		this.miscellenioous = miscellenioous;
		this.month = month;
		this.total = total;
		this.year = year;
	}



	public int getMess() {
		return mess;
	}



	public void setMess(int mess) {
		this.mess = mess;
	}



	public int getLibrary() {
		return library;
	}



	public void setLibrary(int library) {
		this.library = library;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	public int getMaintenance() {
		return maintenance;
	}



	public void setMaintenance(int maintenance) {
		this.maintenance = maintenance;
	}



	public int getGames() {
		return games;
	}



	public void setGames(int games) {
		this.games = games;
	}



	public int getTuition() {
		return tuition;
	}



	public void setTuition(int tuition) {
		this.tuition = tuition;
	}



	public int getFarming() {
		return farming;
	}



	public void setFarming(int farming) {
		this.farming = farming;
	}



	public int getMiscellenioous() {
		return miscellenioous;
	}



	public void setMiscellenioous(int miscellenioous) {
		this.miscellenioous = miscellenioous;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public ManageFinances() {
		// TODO Auto-generated constructor stub
	}

}
