package tn.project.demo.services;

import java.util.List;

import tn.project.demo.dto.ClientDto;

public interface ClientService {

	ClientDto save(ClientDto dto);
	
	ClientDto findById(Integer id);
	
	List<ClientDto> findAll();
	
	void delete(Integer id);
}
