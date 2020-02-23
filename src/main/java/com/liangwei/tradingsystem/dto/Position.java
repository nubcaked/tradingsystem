package com.liangwei.tradingsystem.dto;

public class Position {

    private String ticker;
    private String type;
    private int quantity;
    private double marketValue;

    public Position(String ticker, String type, int quantity) {
        this(ticker, type, quantity, 0.0);
    }

    public Position(String ticker, String type, int quantity, double marketValue) {
        this.ticker = ticker;
        this.type = type;
        this.quantity = quantity;
        this.marketValue = marketValue;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "Position{" +
                "ticker='" + ticker + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                ", marketValue=" + marketValue +
                '}';
    }
}
