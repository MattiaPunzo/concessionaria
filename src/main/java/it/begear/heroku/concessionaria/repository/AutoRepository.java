package it.begear.heroku.concessionaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.begear.heroku.concessionaria.entity.Auto;

public interface AutoRepository extends JpaRepository<Auto, Integer> {
	@Query("SELECT a FROM Auto a WHERE CONCAT(a.marca, a.modello , a.colore, a.prezzo) LIKE %?1%")
	public List<Auto> search(String keyword);
	
	@Query("SELECT a FROM Auto a ORDER BY a.marca")
	public List<Auto> orderByMarca();
	
}
