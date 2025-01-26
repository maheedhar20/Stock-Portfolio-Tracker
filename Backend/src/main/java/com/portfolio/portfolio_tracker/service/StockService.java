package com.portfolio.portfolio_tracker.service;

import com.portfolio.portfolio_tracker.model.*;
import com.portfolio.portfolio_tracker.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    // @Autowired
    // private UserRepository userRepository;

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public List<Stock> getStocksByUser(User user) {
        return stockRepository.findByUser(user);
    }

    public void deleteStock(Long stockId) {
        stockRepository.deleteById(stockId);
    }

    public Stock updateStock(Long stockId, Stock updatedStock) {
        return stockRepository.findById(stockId).map(stock -> {
            stock.setName(updatedStock.getName());
            stock.setTicker(updatedStock.getTicker());
            stock.setQuantity(updatedStock.getQuantity());
            stock.setBuyPrice(updatedStock.getBuyPrice());
            stock.setCurrentPrice(updatedStock.getCurrentPrice());
            return stockRepository.save(stock);
        }).orElseThrow(() -> new RuntimeException("Stock not found"));
    }
}

