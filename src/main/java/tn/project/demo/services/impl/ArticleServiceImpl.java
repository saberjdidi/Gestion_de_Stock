package tn.project.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import tn.project.demo.dto.ArticleDto;
import tn.project.demo.dto.LigneCommandeClientDto;
import tn.project.demo.dto.LigneCommandeFournisseurDto;
import tn.project.demo.dto.LigneVenteDto;
import tn.project.demo.exception.EntityNotFoundException;
import tn.project.demo.exception.ErrorCodes;
import tn.project.demo.exception.InvalidEntityException;
import tn.project.demo.exception.InvalidOperationException;
import tn.project.demo.model.Article;
import tn.project.demo.model.LigneCommandeClient;
import tn.project.demo.model.LigneCommandeFournisseur;
import tn.project.demo.model.LigneVente;
import tn.project.demo.repository.ArticleRepository;
import tn.project.demo.repository.LigneCommandeClientRepository;
import tn.project.demo.repository.LigneCommandeFournisseurRepository;
import tn.project.demo.repository.LigneVenteRepository;
import tn.project.demo.services.ArticleService;
import tn.project.demo.validator.ArticleValidator;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
	
	private ArticleRepository articleRepository;
	  private LigneVenteRepository venteRepository;
	  private LigneCommandeFournisseurRepository commandeFournisseurRepository;
	  private LigneCommandeClientRepository commandeClientRepository;

	  @Autowired
	  public ArticleServiceImpl(
	      ArticleRepository articleRepository,
	      LigneVenteRepository venteRepository, LigneCommandeFournisseurRepository commandeFournisseurRepository,
	      LigneCommandeClientRepository commandeClientRepository) {
	    this.articleRepository = articleRepository;
	    this.venteRepository = venteRepository;
	    this.commandeFournisseurRepository = commandeFournisseurRepository;
	    this.commandeClientRepository = commandeClientRepository;
	  }

	@Override
	public ArticleDto save(ArticleDto dto) {
		List<String> errors = ArticleValidator.validate(dto);
		if(!errors.isEmpty()) {
		//	log.error("Article is not valid {}", dto);
			throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
		}
		
		Article savedArticle = articleRepository.save(ArticleDto.toEntity(dto));
		return ArticleDto.fromEntity(savedArticle);
	}

	@Override
	public ArticleDto findById(Integer id) {
		if (id == null) {
		     // log.error("Article ID is null");
		      return null;
		    }

		    return articleRepository.findById(id).map(ArticleDto::fromEntity).orElseThrow(() ->
		        new EntityNotFoundException(
		            "Aucun article avec l'ID = " + id + " n' ete trouve dans la BDD",
		            ErrorCodes.ARTICLE_NOT_FOUND)
		    );
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		if (!StringUtils.hasLength(codeArticle)) {
		     // log.error("Article CODE is null");
		      return null;
		    }

		    return articleRepository.findArticleByCodeArticle(codeArticle)
		        .map(ArticleDto::fromEntity)  // mapper d'un objet à un autre, faire un appel à la méthode fromEntity
		        .orElseThrow(() ->
		            new EntityNotFoundException(
		                "Aucun article avec le CODE = " + codeArticle + " n' ete trouve dans la BDD",
		                ErrorCodes.ARTICLE_NOT_FOUND)
		        );
	}

	@Override
	public List<ArticleDto> findAll() {
		return articleRepository.findAll().stream()
		        .map(ArticleDto::fromEntity)  //:: est une méthode référence
		        .collect(Collectors.toList()); // regrouper dans une liste
	}

	@Override
	  public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
	    return venteRepository.findAllByArticleId(idArticle).stream()
	        .map(LigneVenteDto::fromEntity)
	        .collect(Collectors.toList());
	  }

	  @Override
	  public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle) {
	    return commandeClientRepository.findAllByArticleId(idArticle).stream()
	        .map(LigneCommandeClientDto::fromEntity)
	        .collect(Collectors.toList());
	  }

	  @Override
	  public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
	    return commandeFournisseurRepository.findAllByArticleId(idArticle).stream()
	        .map(LigneCommandeFournisseurDto::fromEntity)
	        .collect(Collectors.toList());
	  }

	  @Override
	  public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
	    return articleRepository.findAllByCategoryId(idCategory).stream()
	        .map(ArticleDto::fromEntity)
	        .collect(Collectors.toList());
	  }

	  @Override
	  public void delete(Integer id) {
	    if (id == null) {
	      //log.error("Article ID is null");
	      return;
	    }
	    List<LigneCommandeClient> ligneCommandeClients = commandeClientRepository.findAllByArticleId(id);
	    if (!ligneCommandeClients.isEmpty()) {
	      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes client", ErrorCodes.ARTICLE_ALREADY_IN_USE);
	    }
	    List<LigneCommandeFournisseur> ligneCommandeFournisseurs = commandeFournisseurRepository.findAllByArticleId(id);
	    if (!ligneCommandeFournisseurs.isEmpty()) {
	      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes fournisseur",
	          ErrorCodes.ARTICLE_ALREADY_IN_USE);
	    }
	    List<LigneVente> ligneVentes = venteRepository.findAllByArticleId(id);
	    if (!ligneVentes.isEmpty()) {
	      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des ventes",
	          ErrorCodes.ARTICLE_ALREADY_IN_USE);
	    }
	    articleRepository.deleteById(id);
	  }

}
