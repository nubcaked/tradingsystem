package com.liangwei.tradingsystem.entity;

import com.google.common.base.MoreObjects;
import org.h2.tools.SimpleResultSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ticker;
    private String type;
    private Double price;
    private Double expectedReturn;
    private Double standardDeviation;
    private Double strikePrice;
    private String maturityDate;

    protected Security() {}

    public Security(String ticker, String type, Double price, Double expectedReturn, Double standardDeviation) {
        this(ticker, type, price, expectedReturn, standardDeviation, null, null);
    }

    public Security(String ticker, String type, Double price, Double expectedReturn, Double standardDeviation, Double strikePrice, String maturityDate) {
        this.ticker = ticker;
        this.type = type;
        this.price = price;
        this.expectedReturn = expectedReturn;
        this.standardDeviation = standardDeviation;
        this.strikePrice = strikePrice;
        this.maturityDate = maturityDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getExpectedReturn() {
        return expectedReturn;
    }

    public void setExpectedReturn(Double expectedReturn) {
        this.expectedReturn = expectedReturn;
    }

    public Double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(Double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public Double getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(Double strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ticker", this.ticker)
                .add("type", this.type)
                .add("price", this.price)
                .add("strikePrice", this.strikePrice)
                .add("maturityDate", this.maturityDate)
                .toString();
    }
}
