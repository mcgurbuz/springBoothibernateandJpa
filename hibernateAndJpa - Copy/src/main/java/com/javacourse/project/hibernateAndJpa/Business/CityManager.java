package com.javacourse.project.hibernateAndJpa.Business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacourse.project.hibernateAndJpa.DataAccess.ICityDal;
import com.javacourse.project.hibernateAndJpa.Entities.City;
@Service //Sen işkatmanısın diye belirtiyorum. Katmanları belli etmek adına bu önemli Spring frameworkden geliyor.
public class CityManager implements ICityService{
	//Business data accessden hizmet alacak.
	
	private ICityDal cityDal; //Depency Injection
	
	
    @Autowired //Depency Injection ile halledeceğim. Bu ICitydalı çözmem gerekiyor.
    //Sen otomatik olarak Icitydala uygun bir şey varsa git onu al demek istedim Autowired ile
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional //Business için özel Transaction AOP Session aç kapat mantığı
	public List<City> getAll() { //Dataacces için yapmıştık. Buradaki Transactional business için özel
		
		return this.cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		//Şehir eklenmiş ama şu kurallara göre yani iş kuralları yazılır. Bu kısımda sadece ekleme değil
		//İş gereksinimlerine göre burası Müşterimize göre şekillenir.
		this.cityDal.add(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
		
	}

	@Override
	@Transactional
	public City getById(int id) {
		
		return this.cityDal.getById(id);
	}

}
