package tn.project.demo.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import tn.project.demo.dto.UtilisateurDto;


public class UtilisateurValidator {
	
	public static List<String> validate(UtilisateurDto utilisateurDto){
		List<String> errors = new ArrayList<>();
		
		if(utilisateurDto == null) {
			errors.add("Veuillez renseigner le nom");
			errors.add("Veuillez renseigner le prenom");
			errors.add("Veuillez renseigner l'email");
			errors.add("Veuillez renseigner le mot de passe");
			errors.add("Veuillez renseigner l'adresse");
			errors.addAll(AdresseValidator.validate(null));
			return errors;
		}
		
		if(!StringUtils.hasLength(utilisateurDto.getNom())) {
			errors.add("Veuillez renseigner le nom");
		}
		if(!StringUtils.hasLength(utilisateurDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom");
		}
		if(!StringUtils.hasLength(utilisateurDto.getEmail())) {
			errors.add("Veuillez renseigner l'email");
		}
		if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
			errors.add("Veuillez renseigner le mot de passe");
		}
		if(utilisateurDto.getDateDeNaissance() == null) {
			errors.add("Veuillez renseigner la date de naissance");
		}
		
		errors.addAll(AdresseValidator.validate(utilisateurDto.getAdresse()));
	/*	if(utilisateurDto.getAdresse() == null) {
			errors.add("Veuillez renseigner l'adresse");
		} else {
			if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdress1())) {
				errors.add("le champ adresse est obligatoire");
			}
			if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
				errors.add("le champ code postale est obligatoire");
			}
			if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
				errors.add("le champ pays est obligatoire");
			}
		}*/
		return errors;
	}
}
