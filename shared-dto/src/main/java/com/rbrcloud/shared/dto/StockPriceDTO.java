package com.rbrcloud.shared.dto;

import java.math.BigDecimal;

public record StockPriceDTO(String ticker, BigDecimal price, String currency) {
}
