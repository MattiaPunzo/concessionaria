package it.begear.heroku.concessionaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.begear.heroku.concessionaria.entity.Bicicletta;

public interface BiciclettaRepository extends JpaRepository<Bicicletta, Integer> {
	@Query("SELECT b FROM Bicicletta b WHERE CONCAT(b.marca) LIKE %?1% ORDER BY b.marca")
	public List<Bicicletta> searchBicicletta(String keyword);
}
