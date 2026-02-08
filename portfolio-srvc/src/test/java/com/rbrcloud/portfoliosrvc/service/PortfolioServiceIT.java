package com.rbrcloud.portfoliosrvc.service;

import com.rbrcloud.portfoliosrvc.entity.Stock;
import com.rbrcloud.portfoliosrvc.repository.PortfolioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class PortfolioServiceIT {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private PortfolioRepository portfolioRepository;

    @BeforeEach
    public void setup() {
        portfolioRepository.deleteAll();
    }

    @Test
    public void addStockToPortfolio() {
        Stock stock = new Stock(null, "BAC", 20, BigDecimal.valueOf(56.66));
        Stock savedStock = portfolioService.addStockToPortfolio(stock);

        assertNotNull(savedStock.getId());
        assertEquals(stock.getSymbol(), savedStock.getSymbol());

        // Verify in DB
        List<Stock> stocks = portfolioRepository.findAll();
        assertEquals(1, stocks.size());
        assertEquals(stock.getSymbol(), stocks.getFirst().getSymbol());
    }
}
