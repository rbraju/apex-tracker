package com.rbrcloud.marketdatasrvc.controller;

import com.rbrcloud.shared.dto.StockPriceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/market-data")
public class MarketDataController {

    // Simulated data
    private final Map<String, BigDecimal> mockPrices = Map.of(
            "JPM", new BigDecimal("303.22"),
            "AAPL", new BigDecimal("278.10"),
            "MSFT", new BigDecimal("401.14"),
            "EBAY", new BigDecimal("101.25")
    );

    @GetMapping("/{ticker}")
    public ResponseEntity<StockPriceDTO> getPrice(@PathVariable String ticker) {
        BigDecimal price = mockPrices.get(ticker.toUpperCase());

        if (price == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new StockPriceDTO(ticker, price, "USD"));
    }
}
