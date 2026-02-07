package com.rbrcloud.portfoliosrvc.client;

import com.rbrcloud.shared.dto.StockPriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "market-data-srvc", url="${market-data-srvc.url}")
public interface MarketDataClient {

    @GetMapping("/api/v1/market-data/{ticker}")
    StockPriceDTO getPrice(@PathVariable("ticker") String ticker);
}
