package com.liangwei.tradingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ticker;
    private String type;
    private Double strikePrice;
    private Date maturityDate;

    protected Security() {}

    public Security(String ticker, String type) {
        this(ticker, type, null, null);
    }

    public Security(String ticker, String type, Double strikePrice, Date maturityDate) {
        this.ticker = ticker;
        this.type = type;
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

    public Double getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(Double strikePrice) {
        this.strikePrice = strikePrice;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }
}
