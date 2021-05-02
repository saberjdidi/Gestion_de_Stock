package tn.project.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import tn.project.demo.model.Entreprise;

@Data
@Builder
public class EntrepriseDto {
	
	private Integer id;
	
	private String nom;
	
	private String description;
	
	private String codeFiscale;
	
	private String photo;
	
	private AdresseDto adresse;
	
	private String email;
	
	private String numTel;
	
	private String siteWeb;
	
	@JsonIgnore
	private List<UtilisateurDto> utilisateurs;
	
	public static EntrepriseDto fromEntity(Entreprise entreprise) {
	    if (entreprise == null) {
	      return null;
	    }
	    return EntrepriseDto.builder()
	        .id(entreprise.getId())
	        .nom(entreprise.getNom())
	        .description(entreprise.getDescription())
	        .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
	        .codeFiscale(entreprise.getCodeFiscale())
	        .photo(entreprise.getPhoto())
	        .email(entreprise.getEmail())
	        .numTel(entreprise.getNumTel())
	        .siteWeb(entreprise.getSiteWeb())
	        .build();
	  }

	  public static Entreprise toEntity(EntrepriseDto dto) {
	    if (dto == null) {
	      return null;
	    }
	    Entreprise entreprise = new Entreprise();
	    entreprise.setId(dto.getId());
	    entreprise.setNom(dto.getNom());
	    entreprise.setDescription(dto.getDescription());
	    entreprise.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
	    entreprise.setCodeFiscale(dto.getCodeFiscale());
	    entreprise.setPhoto(dto.getPhoto());
	    entreprise.setEmail(dto.getEmail());
	    entreprise.setNumTel(dto.getNumTel());
	    entreprise.setSiteWeb(dto.getSiteWeb());

	    return entreprise;
	  }
}
