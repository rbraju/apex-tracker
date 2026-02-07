package com.rbrcloud.portfoliosrvc.service;

import com.rbrcloud.portfoliosrvc.client.MarketDataClient;
import com.rbrcloud.shared.dto.StockPriceDTO;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    private final MarketDataClient marketDataClient;

    public PortfolioService(MarketDataClient marketDataClient) {
        this.marketDataClient = marketDataClient;
    }

    public StockPriceDTO getStockPrice(String ticker) {
        return marketDataClient.getPrice(ticker);
    }
}
