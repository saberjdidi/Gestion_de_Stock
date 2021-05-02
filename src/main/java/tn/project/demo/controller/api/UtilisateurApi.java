package tn.project.demo.controller.api;

import static tn.project.demo.utils.Constants.UTILISATEUR_ENDPOINT;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import tn.project.demo.dto.UtilisateurDto;

@Api(UTILISATEUR_ENDPOINT)
public interface UtilisateurApi {

	  @PostMapping(UTILISATEUR_ENDPOINT + "/create")
	  UtilisateurDto save(@RequestBody UtilisateurDto dto);

	  //@PostMapping(UTILISATEUR_ENDPOINT + "/update/password")
	  //UtilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

	  @GetMapping(UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
	  UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

	  @GetMapping(UTILISATEUR_ENDPOINT + "/all")
	  List<UtilisateurDto> findAll();

	  @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
	  void delete(@PathVariable("idUtilisateur") Integer id);
}
