package tn.project.demo.dto;


import lombok.Builder;
import lombok.Data;
import tn.project.demo.model.Adresse;

@Data
@Builder
public class AdresseDto {

	private String adress1;
	
	private String adress2;
	
	private String ville;
	
	private String codePostale;
	
	private String pays;
	
	public static AdresseDto fromEntity(Adresse adresse) {
		if(adresse == null) {
			return null;
		}
		
		return AdresseDto.builder()
				.adress1(adresse.getAdress1())
				.adress2(adresse.getAdress2())
				.ville(adresse.getVille())
				.codePostale(adresse.getCodePostale())
				.pays(adresse.getPays())
				.build();
	}
	
	public static Adresse toEntity(AdresseDto adresseDto) {
		if(adresseDto == null) {
			return null;
		}
		
		Adresse adresse = new Adresse();
		adresse.setAdress1(adresseDto.getAdress1());
		adresse.setAdress2(adresseDto.getAdress2());
		adresse.setVille(adresseDto.getVille());
		adresse.setCodePostale(adresseDto.getCodePostale());
		adresse.setPays(adresseDto.getPays());
		return adresse;
	}
}
