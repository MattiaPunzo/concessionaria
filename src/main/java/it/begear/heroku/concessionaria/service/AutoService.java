package it.begear.heroku.concessionaria.service;

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
		if (keyword != null) {
			return repository.search(keyword);
		}
		return repository.findAll();
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
