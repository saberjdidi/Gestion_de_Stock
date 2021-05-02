package tn.project.demo.services.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.project.demo.dto.UtilisateurDto;
import tn.project.demo.exception.EntityNotFoundException;
import tn.project.demo.exception.ErrorCodes;
import tn.project.demo.model.Utilisateur;
import tn.project.demo.model.auth.ExtendedUser;
import tn.project.demo.repository.UtilisateurRepository;
import tn.project.demo.services.UtilisateurService;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	
	@Autowired
	  private UtilisateurService service;


	  @Override
	  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    UtilisateurDto utilisateur = service.findByEmail(email);

	    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	    utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));

	    return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMotDePasse(), utilisateur.getEntreprise().getId(), authorities);
	  }

}
