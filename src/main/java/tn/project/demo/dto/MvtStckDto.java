package tn.project.demo.dto;

import java.math.BigDecimal;
import java.time.Instant;


import lombok.Builder;
import lombok.Data;
import tn.project.demo.model.MvtStck;
import tn.project.demo.model.SourceMvtStk;
import tn.project.demo.model.TypeMvtStk;

@Data
@Builder
public class MvtStckDto {
	
	private Integer id;
	
	private Instant dateMvt;
	
	private BigDecimal quantite;
	
	private ArticleDto article;
	
	private TypeMvtStk typeMvt;
	
	private SourceMvtStk sourceMvt;

	private Integer idEntreprise;

	  public static MvtStckDto fromEntity(MvtStck mvtStk) {
	    if (mvtStk == null) {
	      return null;
	    }

	    return MvtStckDto.builder()
	        .id(mvtStk.getId())
	        .dateMvt(mvtStk.getDateMvt())
	        .quantite(mvtStk.getQuantite())
	        .article(ArticleDto.fromEntity(mvtStk.getArticle()))
	        .typeMvt(mvtStk.getTypeMvt())
	        .sourceMvt(mvtStk.getSourceMvt())
	        .idEntreprise(mvtStk.getIdEntreprise())
	        .build();
	  }

	  public static MvtStck toEntity(MvtStckDto dto) {
	    if (dto == null) {
	      return null;
	    }

	    MvtStck mvtStk = new MvtStck();
	    mvtStk.setId(dto.getId());
	    mvtStk.setDateMvt(dto.getDateMvt());
	    mvtStk.setQuantite(dto.getQuantite());
	    mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
	    mvtStk.setTypeMvt(dto.getTypeMvt());
	    mvtStk.setSourceMvt(dto.getSourceMvt());
	    mvtStk.setIdEntreprise(dto.getIdEntreprise());
	    return mvtStk;
	  }
}
