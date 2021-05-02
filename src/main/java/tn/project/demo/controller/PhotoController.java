package tn.project.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.flickr4java.flickr.FlickrException;

import tn.project.demo.controller.api.PhotoApi;
import tn.project.demo.services.strategy.StrategyPhotoContext;

public class PhotoController implements PhotoApi {

	private StrategyPhotoContext strategyPhotoContext;

	  @Autowired
	  public PhotoController(StrategyPhotoContext strategyPhotoContext) {
	    this.strategyPhotoContext = strategyPhotoContext;
	  }

	  @Override
	  public Object savePhoto(String context, Integer id, MultipartFile photo, String title) throws IOException, FlickrException {
	    return strategyPhotoContext.savePhoto(context, id, photo.getInputStream(), title);
	  }
}
