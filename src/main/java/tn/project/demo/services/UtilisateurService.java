package tn.project.demo.services;

import java.util.List;

import tn.project.demo.dto.ChangerMotDePasseUtilisateurDto;
import tn.project.demo.dto.UtilisateurDto;

public interface UtilisateurService {

	UtilisateurDto save(UtilisateurDto dto);
	
	UtilisateurDto findById(Integer id);
	
	List<UtilisateurDto> findAll();
	
	void delete(Integer id);
	
	UtilisateurDto findByEmail(String email);

    UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);
}
