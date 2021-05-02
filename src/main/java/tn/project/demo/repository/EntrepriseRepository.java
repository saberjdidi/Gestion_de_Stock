package tn.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.project.demo.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
