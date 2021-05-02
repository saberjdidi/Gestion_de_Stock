package tn.project.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import tn.project.demo.model.Client;

@Data
@Builder
public class ClientDto {
	
	private Integer id;

	private String nom;
	
	private String prenom;
	
	private String photo;
	
	private AdresseDto adresse;
	
	private String email;
	
	private String numTel;
	
	private Integer idEntreprise;
	
	@JsonIgnore
	private List<CommandeClientDto> commandeClients;
	
	public static ClientDto fromEntity(Client client) {
	    if (client == null) {
	      return null;
	    }
	    return ClientDto.builder()
	        .id(client.getId())
	        .nom(client.getNom())
	        .prenom(client.getPrenom())
	        .adresse(AdresseDto.fromEntity(client.getAdresse()))
	        .photo(client.getPhoto())
	        .email(client.getEmail())
	        .numTel(client.getNumTel())
	        .idEntreprise(client.getIdEntreprise())
	        .build();
	  }

	  public static Client toEntity(ClientDto dto) {
	    if (dto == null) {
	      return null;
	    }
	    Client client = new Client();
	    client.setId(dto.getId());
	    client.setNom(dto.getNom());
	    client.setPrenom(dto.getPrenom());
	    client.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
	    client.setPhoto(dto.getPhoto());
	    client.setEmail(dto.getEmail());
	    client.setNumTel(dto.getNumTel());
	    client.setIdEntreprise(dto.getIdEntreprise());
	    return client;
	  }
}
