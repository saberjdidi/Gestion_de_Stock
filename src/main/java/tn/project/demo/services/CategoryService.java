package tn.project.demo.services;

import java.util.List;

import tn.project.demo.dto.CategoryDto;

public interface CategoryService {

	  CategoryDto save(CategoryDto dto);

	  CategoryDto findById(Integer id);

	  CategoryDto findByCode(String code);

	  List<CategoryDto> findAll();

	  void delete(Integer id);
}
