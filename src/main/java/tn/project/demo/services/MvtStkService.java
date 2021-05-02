package tn.project.demo.services;

import java.math.BigDecimal;
import java.util.List;

import tn.project.demo.dto.MvtStckDto;

public interface MvtStkService {

	  BigDecimal stockReelArticle(Integer idArticle);

	  List<MvtStckDto> mvtStkArticle(Integer idArticle);

	  MvtStckDto entreeStock(MvtStckDto dto);

	  MvtStckDto sortieStock(MvtStckDto dto);

	  MvtStckDto correctionStockPos(MvtStckDto dto);

	  MvtStckDto correctionStockNeg(MvtStckDto dto);
}
