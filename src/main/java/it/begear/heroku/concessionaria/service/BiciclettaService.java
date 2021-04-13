package it.begear.heroku.concessionaria.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.heroku.concessionaria.entity.Bicicletta;
import it.begear.heroku.concessionaria.repository.BiciclettaRepository;

@Service
public class BiciclettaService {

	@Autowired
	private BiciclettaRepository repository;

	public List<Bicicletta> listAll(String keyword) {
		List<Bicicletta> bici = new ArrayList<Bicicletta>();
		if (keyword != null) {
			bici = repository.searchBicicletta(keyword);
		} else {
			bici = repository.findAll();
		}
		Collections.sort(bici, Comparator.comparing(Bicicletta::getMarca));
		return bici;
	}

	public void saveBicicletta(Bicicletta b) {
		repository.save(b);
	}

	public Bicicletta getBici(Integer id_bicicletta) {
		return repository.findById(id_bicicletta).get();
	}

	public void deleteBici(Integer id_bicicletta) {
		repository.deleteById(id_bicicletta);
	}
}
