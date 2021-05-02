package tn.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.project.demo.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

}
