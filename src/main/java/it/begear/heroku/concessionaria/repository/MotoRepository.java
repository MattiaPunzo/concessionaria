package it.begear.heroku.concessionaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.begear.heroku.concessionaria.entity.Moto;

public interface MotoRepository extends JpaRepository<Moto, Integer> {
	@Query("SELECT m FROM Moto m WHERE CONCAT(m.marca) LIKE %?1% ORDER BY m.marca")
	public List<Moto> searchMoto(String keyword);
}
