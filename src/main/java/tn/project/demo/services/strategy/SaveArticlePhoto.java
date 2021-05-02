package tn.project.demo.services.strategy;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.flickr4java.flickr.FlickrException;

import lombok.extern.slf4j.Slf4j;
import tn.project.demo.dto.ArticleDto;
import tn.project.demo.exception.ErrorCodes;
import tn.project.demo.exception.InvalidOperationException;
import tn.project.demo.model.Article;
import tn.project.demo.services.ArticleService;
import tn.project.demo.services.FlickrService;

@Service("articleStrategy")
@Slf4j
public class SaveArticlePhoto implements Strategy<ArticleDto> {

	  private FlickrService flickrService;
	  private ArticleService articleService;

	  @Autowired
	  public SaveArticlePhoto(FlickrService flickrService, ArticleService articleService) {
	    this.flickrService = flickrService;
	    this.articleService = articleService;
	  }
	  
	@Override
	public ArticleDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
		ArticleDto article = articleService.findById(id);
		String urlPhoto = flickrService.savePhoto(photo, titre);
		if(!StringUtils.hasLength(urlPhoto)) {
			throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de l'article", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
		}
		
		article.setPhoto(urlPhoto);
	    return articleService.save(article);
	}

}
