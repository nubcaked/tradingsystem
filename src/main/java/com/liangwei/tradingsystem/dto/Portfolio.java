package com.liangwei.tradingsystem.dto;

import com.liangwei.tradingsystem.entity.Security;
import org.springframework.boot.json.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private List<Position> positionList;
    private double netAssetValue;

    public Portfolio() {
        this(new ArrayList<>(), 0.0);
    }

    public Portfolio(List<Position> positionList, double netAssetValue) {
        this.positionList = positionList;
        this.netAssetValue = netAssetValue;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
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
                "securityList=" + positionList +
                ", netAssetValue=" + netAssetValue +
                '}';
    }

}
