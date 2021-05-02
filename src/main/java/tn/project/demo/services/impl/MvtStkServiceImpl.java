package tn.project.demo.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.project.demo.dto.MvtStckDto;
import tn.project.demo.exception.ErrorCodes;
import tn.project.demo.exception.InvalidEntityException;
import tn.project.demo.model.TypeMvtStk;
import tn.project.demo.repository.MvtStckRepository;
import tn.project.demo.services.ArticleService;
import tn.project.demo.services.MvtStkService;
import tn.project.demo.validator.MvtStkValidator;

@Service
@Slf4j
public class MvtStkServiceImpl implements MvtStkService {

	private MvtStckRepository repository;
	  private ArticleService articleService;

	  @Autowired
	  public MvtStkServiceImpl(MvtStckRepository repository, ArticleService articleService) {
	    this.repository = repository;
	    this.articleService = articleService;
	  }

	  @Override
	  public BigDecimal stockReelArticle(Integer idArticle) {
	    if (idArticle == null) {
	     // log.warn("ID article is NULL");
	      return BigDecimal.valueOf(-1);
	    }
	    articleService.findById(idArticle);
	    return repository.stockReelArticle(idArticle);
	  }

	  @Override
	  public List<MvtStckDto> mvtStkArticle(Integer idArticle) {
	    return repository.findAllByArticleId(idArticle).stream()
	        .map(MvtStckDto::fromEntity)
	        .collect(Collectors.toList());
	  }

	  @Override
	  public MvtStckDto entreeStock(MvtStckDto dto) {
	    return entreePositive(dto, TypeMvtStk.ENTREE);
	  }

	  @Override
	  public MvtStckDto sortieStock(MvtStckDto dto) {
	    return sortieNegative(dto, TypeMvtStk.SORTIE);
	  }

	  @Override
	  public MvtStckDto correctionStockPos(MvtStckDto dto) {
	    return entreePositive(dto, TypeMvtStk.CORRECTION_POS);
	  }

	  @Override
	  public MvtStckDto correctionStockNeg(MvtStckDto dto) {
	    return sortieNegative(dto, TypeMvtStk.CORRECTION_NEG);
	  }

	  private MvtStckDto entreePositive(MvtStckDto dto, TypeMvtStk typeMvtStk) {
	    List<String> errors = MvtStkValidator.validate(dto);
	    if (!errors.isEmpty()) {
	      log.error("Article is not valid {}", dto);
	      throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
	    }
	    dto.setQuantite(
	        BigDecimal.valueOf(
	            Math.abs(dto.getQuantite().doubleValue())
	        )
	    );
	    dto.setTypeMvt(typeMvtStk);
	    return MvtStckDto.fromEntity(
	        repository.save(MvtStckDto.toEntity(dto))
	    );
	  }

	  private MvtStckDto sortieNegative(MvtStckDto dto, TypeMvtStk typeMvtStk) {
	    List<String> errors = MvtStkValidator.validate(dto);
	    if (!errors.isEmpty()) {
	      log.error("Article is not valid {}", dto);
	      throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
	    }
	    dto.setQuantite(
	        BigDecimal.valueOf(
	            Math.abs(dto.getQuantite().doubleValue()) * -1
	        )
	    );
	    dto.setTypeMvt(typeMvtStk);
	    return MvtStckDto.fromEntity(
	        repository.save(MvtStckDto.toEntity(dto))
	    );
	  }
}
