package com.rbrcloud.portfoliosrvc.service;

import com.rbrcloud.portfoliosrvc.entity.Stock;
import com.rbrcloud.portfoliosrvc.repository.PortfolioRepository;
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
public class PortfolioServiceTest {

    @Mock
    private PortfolioRepository portfolioRepository;

    @InjectMocks
    private PortfolioService portfolioService;

    @Test
    public void addValidStockToPortfolio_returnsStock() {
        // Arrange
        Stock stock = new Stock(null, "MSFT", 30, BigDecimal.valueOf(395.35));
        when(portfolioRepository.save(any(Stock.class))).thenReturn(stock);

        // Act
        Stock savedStock = portfolioService.addStockToPortfolio(stock);

        // Assert
        assertNotNull(savedStock);
        assertEquals(stock.getSymbol(), savedStock.getSymbol());
        verify(portfolioRepository, times(1)).save(stock);
    }

    @Test
    public void addInvalidStockQuantityToPortfolio() {
        // Arrange
        Stock stock = new Stock(null, "MSFT", 0, BigDecimal.valueOf(395.35));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            portfolioService.addStockToPortfolio(stock);
        });
        verify(portfolioRepository, never()).save(any(Stock.class));
    }
}
