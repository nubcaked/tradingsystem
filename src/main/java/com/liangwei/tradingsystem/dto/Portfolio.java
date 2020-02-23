package com.liangwei.tradingsystem.dto;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private Map<String, Position> positionMap;
    private double netAssetValue;

    public Portfolio() {
        this(new HashMap<>(), 0.0);
    }

    public Portfolio(Map<String, Position> positionMap, double netAssetValue) {
        this.positionMap = positionMap;
        this.netAssetValue = netAssetValue;
    }

    public Map<String, Position> getPositionMap() {
        return positionMap;
    }

    public void setPositionMap(Map<String, Position> positionMap) {
        this.positionMap = positionMap;
    }

    public double getNetAssetValue() {
        return netAssetValue;
    }

    public void setNetAssetValue(double netAssetValue) {
        this.netAssetValue = netAssetValue;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "positionMap=" + positionMap +
                ", netAssetValue=" + netAssetValue +
                '}';
    }

}
