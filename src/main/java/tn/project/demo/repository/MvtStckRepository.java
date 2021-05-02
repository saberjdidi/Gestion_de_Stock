package tn.project.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.project.demo.model.MvtStck;

public interface MvtStckRepository extends JpaRepository<MvtStck, Integer> {

	  @Query("select sum(m.quantite) from MvtStk m where m.article.id = :idArticle")
	  BigDecimal stockReelArticle(@Param("idArticle") Integer idArticle);

	  List<MvtStck> findAllByArticleId(Integer idArticle);
}
