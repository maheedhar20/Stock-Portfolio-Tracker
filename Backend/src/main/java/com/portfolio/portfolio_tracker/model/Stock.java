package com.portfolio.portfolio_tracker.model;
import jakarta.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ticker;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double buyPrice;

    @Column(nullable = false)
    private Double currentPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Stock() {}

    public Stock(String name, String ticker, Integer quantity, Double buyPrice, Double currentPrice, User user) {
        this.name = name;
        this.ticker = ticker;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.currentPrice = currentPrice;
        this.user = user;
    }

    public String getName(){return this.name;}
    public String getTicker(){return this.ticker;}
    public Integer getQuantity(){return this.quantity;}
    public Double getBuyPrice(){return this.buyPrice;}
    public Double getCurrentPrice(){return this.currentPrice;}

    public void setName(String s){this.name=s;}
    public void setTicker(String s){this.ticker=s;}
    public void setQuantity(Integer i){this.quantity=i;}
    public void setBuyPrice(Double p){this.buyPrice=p;}
    public void setCurrentPrice(Double p){this.currentPrice=p;}

}
