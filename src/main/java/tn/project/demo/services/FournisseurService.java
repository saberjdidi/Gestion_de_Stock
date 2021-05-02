package tn.project.demo.services;

import java.util.List;

import tn.project.demo.dto.FournisseurDto;

public interface FournisseurService {

	FournisseurDto save(FournisseurDto dto);

	  FournisseurDto findById(Integer id);

	  List<FournisseurDto> findAll();

	  void delete(Integer id);
}
