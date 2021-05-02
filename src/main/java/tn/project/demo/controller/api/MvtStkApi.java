package tn.project.demo.controller.api;

import static tn.project.demo.utils.Constants.APP_ROOT;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import tn.project.demo.dto.MvtStckDto;

@Api(APP_ROOT + "/mvtstk")
public interface MvtStkApi {

	  @GetMapping(APP_ROOT + "/mvtstk/stockreel/{idArticle}")
	  BigDecimal stockReelArticle(@PathVariable("idArticle") Integer idArticle);

	  @GetMapping(APP_ROOT + "/mvtstk/filter/article/{idArticle}")
	  List<MvtStckDto> mvtStkArticle(@PathVariable("idArticle") Integer idArticle);

	  @PostMapping(APP_ROOT + "/mvtstk/entree")
	  MvtStckDto entreeStock(@RequestBody MvtStckDto dto);

	  @PostMapping(APP_ROOT + "/mvtstk/sortie")
	  MvtStckDto sortieStock(@RequestBody MvtStckDto dto);

	  @PostMapping(APP_ROOT + "/mvtstk/correctionpos")
	  MvtStckDto correctionStockPos(@RequestBody MvtStckDto dto);

	  @PostMapping(APP_ROOT + "/mvtstk/correctionneg")
	  MvtStckDto correctionStockNeg(@RequestBody MvtStckDto dto);
}
