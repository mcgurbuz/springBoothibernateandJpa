package com.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;
//import com.javacourse.project.hibernateAndJpa.Entities;
//Entities eyvallah ama Entities altında ne ?onu belli etmek için City olanı ekledik...
import com.javacourse.project.hibernateAndJpa.Entities.City;
//List <City> için diğer paketten import ettim
public interface ICityDal {
	
		
		//Interfacesi oluşturmamın amacı Entity katmanıyla haberleşmesi için.
		//Operasyonları burada yazarım
	
	List<City> getAll(); //Şehirleri listemek istiyorum.
	
	//CRUD operasyonları
	void add(City city); //Bana city parametresi ver diyor.
	void update(City city);
	void delete(City city);
	City getById(int id);

	
}
