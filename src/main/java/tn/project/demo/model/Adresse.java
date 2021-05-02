package tn.project.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
@Embeddable
public class Adresse implements Serializable {
	@Column(name="adress1")
	private String adress1;
	
	@Column(name="adress2")
	private String adress2;
	
	@Column(name="ville")
	private String ville;
	
	@Column(name="codepostale")
	private String codePostale;
	
	@Column(name="pays")
	private String pays;

}
