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
}
