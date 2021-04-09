package it.begear.heroku.concessionaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.begear.heroku.concessionaria.entity.Auto;

public interface AutoRepository extends JpaRepository<Auto, Integer> {
	@Query("SELECT a FROM Auto a WHERE CONCAT(a.marca) LIKE %?1% ORDER BY a.marca")
	public List<Auto> searchAuto(String keyword);
	
}
