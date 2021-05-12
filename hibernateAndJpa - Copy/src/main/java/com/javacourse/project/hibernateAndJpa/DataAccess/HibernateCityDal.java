package com.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.Entities.City;

@Repository //Sen yarın o bir gün  hibernateden başka bir yere geçersen buradan silip Repository diğeridir diye belirteceğim.
//CityManager ICityDal gördüm ama nasıl implemente edeceğimi bilemedim diyor Normalde Hibernate @Autowired ile bulması gerkeiyordu 
public class HibernateCityDal implements ICityDal{
	//JPA standart: Veri erişim tekniği
    //Normalde JPA hibernate session aç ve session kapatmamız gerekiyor.
	//Hibernate ve spring JPA yı implement ediyor.
	//Oluşturulan hibernate Sessionfactory ve session nesnesi otomatikman enjekte ediliyor.
	
	private EntityManager entityManager;
	//Bu sınıf JPA dan gelen sessiona karşılık geliyor.
	
	@Autowired//Sen otomatik olarak entitymanager karşılığını otomatikman ne olduğunu gerekli parametrelere bak
	//Bizde hibernate var sen git ara diyoruz ve gerçekleştir diyoruz. Sessionfactory ve sessionu enjecte edeceğiz.
	public HibernateCityDal(EntityManager entityManager) {
			
			this.entityManager = entityManager;
		}
	
	
	
	@Override
	@Transactional //getAll başına ve sonuna Transactional açıyor Bu olaya AOP: Aspect Oriented Programming
	//Kod build olduğunda kodun önüne ve arkasına session koyuyor.//Spring framework ile yapıyoruz bunu
	public List<City> getAll() {
		
		Session session = entityManager.unwrap(Session.class);
		//JPA ya biz Hibernate sessionu ver diyoruz.
		//UOW-->Unit of work desing: Session aç session kapat
		List<City> cities = session.createQuery("from City",City.class).getResultList();
		//Bu City sınıfıyla map ediyor. Sorgumu burada yazdım ve City nesnesi alan Listeye attım 
		//getAll deyince bütün şehirleri listeleyeceğim.
		return cities;
	}

	@Override
	@Transactional
	public void add(City city) {
		// Id si olmayan bir kayıt için direk ekliyor.
		// Id belirtirsem update ediyor. İkisi aynı metot. SaveorUpdate
		Session session = entityManager.unwrap(Session.class); //Session açıyorum
		session.saveOrUpdate(city); //Add yaptığım zaman id vermezsem ekleyecektir.Vermezsem güncelleyektir.!!
	}

	@Override
	@Transactional
	public void update(City city) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(city); //Add ve Update için metotlar aynı saveOrUpdate
	}

	@Override
	@Transactional
	public void delete(City city) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.delete(city);
	}

	@Override
	@Transactional
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class, id); //İlgili id deki şehire ulaşmam gerekiyor.
		//City nesnesine map etsin ve id istiyorum
		return city;
	}
	
	//Aman transactional'ı tüm metodlarına koymayı unutma
	//patlarsın sonra...
	
}
