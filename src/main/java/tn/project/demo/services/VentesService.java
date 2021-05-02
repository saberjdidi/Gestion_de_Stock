package tn.project.demo.services;

import java.util.List;

import tn.project.demo.dto.VentesDto;

public interface VentesService {
	
	  VentesDto save(VentesDto dto);

	  VentesDto findById(Integer id);

	  VentesDto findByCode(String code);

	  List<VentesDto> findAll();

	  void delete(Integer id);
}
