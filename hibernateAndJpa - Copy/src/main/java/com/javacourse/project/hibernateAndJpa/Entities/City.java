package com.javacourse.project.hibernateAndJpa.Entities;

import javax.persistence.*;

//



@Entity // Sen bir veritabanı nesnesisin diyorum.
@Table(name="city") //Veritabanında city tablosuna karşılık geliyor.
public class City {
	@Id     //Id anotasyonu tabloda ana işlemlerin yapılacağı ve diğer tablolarla haberleşmeyi sağlayan primarykey olan  //id kolonuna verilir. Bu kolon sayesinde diğer tablolarla bağlantı sağlanır. 
	                              
	@Column(name="ID")  //Hangi kolona denk geliyor.
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Id alanı bir IDENTITY yani otomatik artacağını söylüyorum.
	private int id;
	@Column(name="name") //Veritabanımın sutünları anlamına geliyor. name özelliği name sütunu demek.
	private String name;
	@Column(name="countrycode")
	private String countrycode;
	@Column(name="population")
	private int population;
	
	
	public City() {
		
		//Default constructor 
	}
	
	//Constructor
	public City(int id, String name, String countrycode, int population) {
		
		this.id = id;
		this.name = name;
		this.countrycode = countrycode;
		this.population = population;
	}
	

	//Getter ve setter : Değer verip değer aldığım özellikler
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


	public String getCountrycode() {
		return countrycode;
	}


	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}


	public int getPopulation() {
		return population;
	}


	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	
	
	
	
	

}
