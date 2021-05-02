package tn.project.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import tn.project.demo.controller.api.MvtStkApi;
import tn.project.demo.dto.MvtStckDto;
import tn.project.demo.services.MvtStkService;

@RestController
public class MvtStkController implements MvtStkApi {

	private MvtStkService service;

	  @Autowired
	  public MvtStkController(MvtStkService service) {
	    this.service = service;
	  }

	  @Override
	  public BigDecimal stockReelArticle(Integer idArticle) {
	    return service.stockReelArticle(idArticle);
	  }

	  @Override
	  public List<MvtStckDto> mvtStkArticle(Integer idArticle) {
	    return service.mvtStkArticle(idArticle);
	  }

	  @Override
	  public MvtStckDto entreeStock(MvtStckDto dto) {
	    return service.entreeStock(dto);
	  }

	  @Override
	  public MvtStckDto sortieStock(MvtStckDto dto) {
	    return service.sortieStock(dto);
	  }

	  @Override
	  public MvtStckDto correctionStockPos(MvtStckDto dto) {
	    return service.correctionStockPos(dto);
	  }

	  @Override
	  public MvtStckDto correctionStockNeg(MvtStckDto dto) {
	    return service.correctionStockNeg(dto);
	  }
}
