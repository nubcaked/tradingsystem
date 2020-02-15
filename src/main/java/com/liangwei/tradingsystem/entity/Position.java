package com.liangwei.tradingsystem.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Position {

    private List<Map<String, Integer>> holdings;

    public Position() {
//        this(new ArrayList<Map<String, Integer>>());
    }

    public Position(List<Map<String, Integer>> holdings) {
        this.holdings = holdings;
    }

    public List<Map<String, Integer>> getHoldings() {
        return holdings;
    }

    public void setHoldings(List<Map<String, Integer>> holdings) {
        this.holdings = holdings;
    }

}
