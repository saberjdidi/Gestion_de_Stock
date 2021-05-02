package tn.project.demo.services;

import java.util.List;

import tn.project.demo.dto.ArticleDto;
import tn.project.demo.dto.LigneCommandeClientDto;
import tn.project.demo.dto.LigneCommandeFournisseurDto;
import tn.project.demo.dto.LigneVenteDto;

public interface ArticleService {

	ArticleDto save(ArticleDto dto);
	
	ArticleDto findById(Integer id);
	
	ArticleDto findByCodeArticle(String codeArticle);
	
	List<ArticleDto> findAll();
	
	List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

	  List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

	  List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

	  List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);
	
	void delete(Integer id);
}
