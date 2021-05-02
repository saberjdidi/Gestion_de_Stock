package tn.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.project.demo.model.LigneCommandeClient;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {

	List<LigneCommandeClient> findAllByCommandeClientId(Integer id);

	List<LigneCommandeClient> findAllByArticleId(Integer id);
}
