package tn.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.project.demo.model.Ventes;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

	Optional<Ventes> findVentesByCode(String code);
}
