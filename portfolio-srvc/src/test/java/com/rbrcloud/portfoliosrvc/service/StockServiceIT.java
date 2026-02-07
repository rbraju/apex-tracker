package com.rbrcloud.portfoliosrvc.service;

import com.rbrcloud.portfoliosrvc.entity.Stock;
import com.rbrcloud.portfoliosrvc.repository.StockRepository;
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
public class StockServiceIT {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    public void setup() {
        stockRepository.deleteAll();
    }

    @Test
    public void addStockToPortfolio() {
        Stock stock = new Stock(null, "BAC", 20, BigDecimal.valueOf(56.66));
        Stock savedStock = stockService.addStockToPortfolio(stock);

        assertNotNull(savedStock.getId());
        assertEquals(stock.getSymbol(), savedStock.getSymbol());

        // Verify in DB
        List<Stock> stocks = stockRepository.findAll();
        assertEquals(1, stocks.size());
        assertEquals(stock.getSymbol(), stocks.getFirst().getSymbol());
    }
}
