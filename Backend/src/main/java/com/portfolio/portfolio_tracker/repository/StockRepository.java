package com.portfolio.portfolio_tracker.repository;

import com.portfolio.portfolio_tracker.model.Stock;
import com.portfolio.portfolio_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByUser(User user);
}
