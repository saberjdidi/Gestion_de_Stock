package tn.project.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import tn.project.demo.model.Fournisseur;

@Data
@Builder
public class FournisseurDto {
	
	private Integer id;

    private String nom;
	
	private String prenom;
	
	private String photo;
	
	private AdresseDto adresse;
	
	private String email;
	
	private String numTel;
	
	private Integer idEntreprise;
	
	@JsonIgnore
	private List<CommandeFournisseurDto> commandeFournisseurs;
	
	public static FournisseurDto fromEntity(Fournisseur fournisseur) {
	    if (fournisseur == null) {
	      return null;
	    }
	    return FournisseurDto.builder()
	        .id(fournisseur.getId())
	        .nom(fournisseur.getNom())
	        .prenom(fournisseur.getPrenom())
	        .adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
	        .photo(fournisseur.getPhoto())
	        .email(fournisseur.getEmail())
	        .numTel(fournisseur.getNumTel())
	        .idEntreprise(fournisseur.getIdEntreprise())
	        .build();
	  }

	  public static Fournisseur toEntity(FournisseurDto dto) {
	    if (dto == null) {
	      return null;
	    }
	    Fournisseur fournisseur = new Fournisseur();
	    fournisseur.setId(dto.getId());
	    fournisseur.setNom(dto.getNom());
	    fournisseur.setPrenom(dto.getPrenom());
	    fournisseur.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
	    fournisseur.setPhoto(dto.getPhoto());
	    fournisseur.setEmail(dto.getEmail());
	    fournisseur.setNumTel(dto.getNumTel());
	    fournisseur.setIdEntreprise(dto.getIdEntreprise());

	    return fournisseur;
	  }
}
