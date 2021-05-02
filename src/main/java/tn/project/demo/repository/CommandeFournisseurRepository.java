package tn.project.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.project.demo.model.CommandeClient;
import tn.project.demo.model.CommandeFournisseur;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

	  Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

	  List<CommandeFournisseur> findAllByFournisseurId(Integer id);
}
