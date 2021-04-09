package it.begear.heroku.concessionaria.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.heroku.concessionaria.entity.Moto;
import it.begear.heroku.concessionaria.repository.MotoRepository;

@Service
public class MotoService {
	@Autowired
	private MotoRepository repository;

	public List<Moto> ListAllMoto(String keyword) {
		List<Moto> moto = new ArrayList<Moto>();
		if (keyword != null) {
			moto = repository.searchMoto(keyword);
		} else {
			moto = repository.findAll();
		}

		Collections.sort(moto, Comparator.comparing(Moto::getMarca));
		return moto;
		
	}

	public void saveMoto(Moto moto) {
		repository.save(moto);
	}

	public Moto getMoto(Integer id_moto) {
		return repository.findById(id_moto).get();
	}

	public void deleteMoto(Integer id_moto) {
		repository.deleteById(id_moto);
	}

}
