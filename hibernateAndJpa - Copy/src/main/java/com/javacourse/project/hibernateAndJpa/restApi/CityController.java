package com.javacourse.project.hibernateAndJpa.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.javacourse.project.hibernateAndJpa.Business.ICityService;
import com.javacourse.project.hibernateAndJpa.Entities.*; //

@RestController //Bunun bir API kontroller olabilmesi için Annotation koyuyoruz.Sen bir RestControllersin
@RequestMapping("/api") //Kullanıcı bunun api olduğunu anlar. Bu bir standarttır.Bu classdaki tüm operasyonlar apiyle başlayacak.
public class CityController {
	
	
	private ICityService cityService;
	@Autowired //Injeksiyonu spring bizim için otomatik olarak bulacak.
	public CityController(ICityService cityService) {
		
		this.cityService = cityService;
	}
	
	@GetMapping("/cities") //localhost/api/cities dediğimde gelmesini istiyorum.
	//GET veritabanında ben bir şey yapmak istiyorum bana veri ver demek DİĞER OPERASYONLAR POSTMAPPİNG
	public List<City> get(){
		
		return cityService.getAll();
		
	}
	
	@PostMapping("/add") //POST YANİ GÖNDERİMİ DURUMU SÖZ KONUSU: EKLEME SİLME VE GÜNCELLEME İÇİN 
	public void add(@RequestBody City city){ //Burdaki parametreyi biz nerden alacağız?
		//Yapılan işlemin bodysinden @RequestBody ile!
		
		cityService.add(city);
		
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody City city){
		
		cityService.delete(city);
		
	}
	
	@PostMapping("/update")
	public void update(@RequestBody City city){
		
		cityService.update(city);
		
	}
	
	@GetMapping("/cities/{id}") //cities bir parametre göndermeliyiz. Dinamik bir şey olduğu için {id} parametresi istiyorum demek!
	public City getById(@PathVariable int id){ //Restful apimiz yolu : PathVariable 
		//Yani bu yoldan aynı isimdeki int id ve cities id aynı isimde olması gerekiyor.Oradan id oku diyoruz.
		
		return cityService.getById(id); //İlgili id parametre olarak veriyoruz.
		
	}
	
	
	
	

}
