package com.rbrcloud.portfoliosrvc.service;

import com.rbrcloud.portfoliosrvc.client.MarketDataClient;
import com.rbrcloud.portfoliosrvc.entity.Stock;
import com.rbrcloud.portfoliosrvc.repository.PortfolioRepository;
import com.rbrcloud.shared.constants.KafkaTopics;
import com.rbrcloud.shared.dto.StockPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    private final MarketDataClient marketDataClient;

    private final KafkaProducerService kafkaProducerService;

    private final PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioService(MarketDataClient marketDataClient,
                            KafkaProducerService kafkaProducerService,
                            PortfolioRepository portfolioRepository) {
        this.marketDataClient = marketDataClient;
        this.kafkaProducerService = kafkaProducerService;
        this.portfolioRepository = portfolioRepository;
    }

    public Stock addStockToPortfolio(Stock stock) {
        if (stock.getQuantity() < 1) {
            throw new IllegalArgumentException("Stock quantity must be at least 1");
        }
        Stock savedStock = portfolioRepository.save(stock);

        // Publish this save event to kafka
        String message = "Stock added to portfolio: " + savedStock.getSymbol();
        kafkaProducerService.sendMessage(KafkaTopics.PORTFOLIO_UPDATE, message);

        return savedStock;
    }

    public List<Stock> getStocksFromPortfolio() {
        return portfolioRepository.findAll();
    }

    public StockPriceDTO getStockPrice(String ticker) {
        return marketDataClient.getPrice(ticker);
    }
}
