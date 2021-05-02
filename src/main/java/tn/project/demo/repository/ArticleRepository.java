package tn.project.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.project.demo.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

/*	@Query("select a from article where codearticle = :code and designation = :designation") //requete jipituelle
	List<Article> findByCustomQuery(@Param("code") String c, @Param("designation") String d);
	
	@Query(value = "select * from article where code = :code", nativeQuery = true)
	List<Article> findByCustomNativeQuery(@Param("code") String c); 
	*/
	
	Optional<Article> findArticleByCodeArticle(String codeArticle);
	
	List<Article> findAllByCategoryId(Integer idCategory);
	
	//IgnoreCase: ignorer la case càd prend majuscule ou miniscule c'est la meme
}
