package com.rbrcloud.portfoliosrvc.controller;

import com.rbrcloud.portfoliosrvc.service.PortfolioService;
import com.rbrcloud.shared.dto.StockPriceDTO;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/{ticker}/price")
    public StockPriceDTO getStockPrice(
            @PathVariable @NotBlank(message = "Ticker cannot be blank") String ticker) {
        return portfolioService.getStockPrice(ticker);
    }
}
