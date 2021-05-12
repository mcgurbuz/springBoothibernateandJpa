package com.javacourse.project.hibernateAndJpa.Business;

import java.util.List;

import com.javacourse.project.hibernateAndJpa.Entities.City;

public interface ICityService {
	
	
	//İmzalar zamanla değişebiliyor.Data erişim katmanındaki interfaceden ayırdık.
	//Business katmanının interfacesi olması lazım.
	List<City> getAll();
	void add(City city); 
	void update(City city);
	void delete(City city);
	City getById(int id);
	
	

}
