package com.portfolio.portfolio_tracker.controller;

import com.portfolio.portfolio_tracker.model.*;
import com.portfolio.portfolio_tracker.repository.UserRepository;
import com.portfolio.portfolio_tracker.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "http://localhost:3000")
public class StockController {
    @Autowired
    private StockService stockService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addStock(@RequestBody Stock stock) {
        try {
            stockService.addStock(stock);
            return ResponseEntity.ok("Stock added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error adding stock");
        }
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Stock>> getStocksByUser(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            List<Stock> stocks = stockService.getStocksByUser(user);
            return ResponseEntity.ok(stocks);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable Long id) {
        try {
            stockService.deleteStock(id);
            return ResponseEntity.ok("Stock deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting stock");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        try {
            stockService.updateStock(id, stock);
            return ResponseEntity.ok("Stock updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating stock");
        }
    }
}

