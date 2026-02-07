package com.rbrcloud.portfoliosrvc;

import com.rbrcloud.portfoliosrvc.client.MarketDataClient;
import com.rbrcloud.portfoliosrvc.service.PortfolioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class PortfolioSrvcApplicationTests {

	@MockitoBean
	private MarketDataClient marketDataClient;

	@InjectMocks
	private PortfolioService portfolioService;

	@Test
	void contextLoads() {
	}

}
