package com.liangwei.tradingsystem.dto;

import com.liangwei.tradingsystem.entity.Security;
import org.springframework.boot.json.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private List<Security> securityList;
    private double netAssetValue;

    public Portfolio() {
        this(new ArrayList<>(), 0.0);
    }

    public Portfolio(List<Security> securityList, double netAssetValue) {
        this.securityList = securityList;
        this.netAssetValue = netAssetValue;
    }

    public List<Security> getSecurityList() {
        return securityList;
    }

    public void setSecurityList(List<Security> securityList) {
        this.securityList = securityList;
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
                "securityList=" + securityList +
                ", netAssetValue=" + netAssetValue +
                '}';
    }

}
