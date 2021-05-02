package tn.project.demo.controller;

import static tn.project.demo.utils.Constants.AUTHENTICATION_ENDPOINT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.project.demo.dto.auth.AuthenticationRequest;
import tn.project.demo.dto.auth.AuthenticationResponse;
import tn.project.demo.model.auth.ExtendedUser;
import tn.project.demo.services.auth.ApplicationUserDetailsService;
import tn.project.demo.utils.JwtUtil;

@RestController
@RequestMapping(AUTHENTICATION_ENDPOINT)
public class AuthenticationController {

	@Autowired
	  private AuthenticationManager authenticationManager;

	  @Autowired
	  private ApplicationUserDetailsService userDetailsService;

	  @Autowired
	  private JwtUtil jwtUtil;

	  @PostMapping("/authenticate")
	  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
	    authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(
	            request.getLogin(),
	            request.getPassword()
	        )
	    );
	    final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

	    final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);

	    return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
	  }
}
