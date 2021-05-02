package tn.project.demo.services;

import java.util.List;

import tn.project.demo.dto.EntrepriseDto;

public interface EntrepriseService {

	EntrepriseDto save(EntrepriseDto dto);

	EntrepriseDto findById(Integer id);

	List<EntrepriseDto> findAll();

	void delete(Integer id);
}
