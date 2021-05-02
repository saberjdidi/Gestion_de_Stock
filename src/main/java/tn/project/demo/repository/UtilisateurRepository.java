package tn.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.project.demo.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

	// JPQL query
	  @Query(value = "select u from Utilisateur u where u.email = :email")
	  Optional<Utilisateur> findUtilisateurByEmail(@Param("email") String email);
}
