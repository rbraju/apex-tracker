package com.rbrcloud.portfoliosrvc.repository;

import com.rbrcloud.portfoliosrvc.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Stock entities.
 */
@Repository
public interface PortfolioRepository extends JpaRepository<Stock, Long> {

    List<Stock> findBySymbol(String symbol);
}
