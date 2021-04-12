package it.begear.heroku.concessionaria.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.heroku.concessionaria.entity.Auto;
import it.begear.heroku.concessionaria.repository.AutoRepository;

@Service
public class AutoService {

	@Autowired
	private AutoRepository repository;

	public List<Auto> ListAll(String keyword) {
		List<Auto> auto = new ArrayList<Auto>();
		if (keyword != null) {
			auto = repository.searchAuto(keyword);
		} else {
			 auto = repository.findAll();
		}
	   Collections.sort(auto, Comparator.comparing(Auto::getMarca)); 
	   return auto;
	}

	public void save(Auto a) {
		repository.save(a);
	}

	public Auto getAuto(Integer id_auto) {
		return repository.findById(id_auto).get();
	}

	public void delete(Integer id_auto) {
		repository.deleteById(id_auto);
	}
	
}
