package com.rbrcloud.portfoliosrvc.service;

import com.rbrcloud.portfoliosrvc.entity.Stock;
import com.rbrcloud.portfoliosrvc.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    @Test
    public void addValidStockToPortfolio_returnsStock() {
        // Arrange
        Stock stock = new Stock(null, "MSFT", 30, BigDecimal.valueOf(395.35));
        when(stockRepository.save(any(Stock.class))).thenReturn(stock);

        // Act
        Stock savedStock = stockService.addStockToPortfolio(stock);

        // Assert
        assertNotNull(savedStock);
        assertEquals(stock.getSymbol(), savedStock.getSymbol());
        verify(stockRepository, times(1)).save(stock);
    }

    @Test
    public void addInvalidStockQuantityToPortfolio() {
        // Arrange
        Stock stock = new Stock(null, "MSFT", 0, BigDecimal.valueOf(395.35));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            stockService.addStockToPortfolio(stock);
        });
        verify(stockRepository, never()).save(any(Stock.class));
    }
}
