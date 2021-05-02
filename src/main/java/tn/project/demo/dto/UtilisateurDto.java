package tn.project.demo.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import tn.project.demo.model.Adresse;
import tn.project.demo.model.Entreprise;
import tn.project.demo.model.Roles;
import tn.project.demo.model.Utilisateur;

@Data
@Builder
public class UtilisateurDto {
	
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private String photo;
	
	private AdresseDto adresse;
	
	private String email;
	
	private String motDePasse;
	
	private Instant dateDeNaissance;
	
	private EntrepriseDto entreprise;
	
	private List<RolesDto> roles;
	
	public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
	    if (utilisateur == null) {
	      return null;
	    }

	    return UtilisateurDto.builder()
	        .id(utilisateur.getId())
	        .nom(utilisateur.getNom())
	        .prenom(utilisateur.getPrenom())
	        .email(utilisateur.getEmail())
	        .motDePasse(utilisateur.getMotDePasse())
	        .dateDeNaissance(utilisateur.getDateDeNaissance())
	        .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
	        .photo(utilisateur.getPhoto())
	        .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
	        .roles(
	            utilisateur.getRoles() != null ?
	                utilisateur.getRoles().stream()
	                    .map(RolesDto::fromEntity)
	                    .collect(Collectors.toList()) : null
	        )
	        .build();
	  }

	  public static Utilisateur toEntity(UtilisateurDto dto) {
	    if (dto == null) {
	      return null;
	    }

	    Utilisateur utilisateur = new Utilisateur();
	    utilisateur.setId(dto.getId());
	    utilisateur.setNom(dto.getNom());
	    utilisateur.setPrenom(dto.getPrenom());
	    utilisateur.setEmail(dto.getEmail());
	    utilisateur.setMotDePasse(dto.getMotDePasse());
	    utilisateur.setDateDeNaissance(dto.getDateDeNaissance());
	    utilisateur.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
	    utilisateur.setPhoto(dto.getPhoto());
	    utilisateur.setEntreprise(EntrepriseDto.toEntity(dto.getEntreprise()));

	    return utilisateur;
	  }
}
