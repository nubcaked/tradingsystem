package com.liangwei.tradingsystem.dto;

public class Position {

    private String ticker;
    private String type;
    private int quantity;

    public Position(String ticker, String type, int quantity) {
        this.ticker = ticker;
        this.type = type;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "Position{" +
                "ticker='" + ticker + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
