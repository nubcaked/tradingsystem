package com.liangwei.tradingsystem.service;

import com.liangwei.tradingsystem.dto.Portfolio;
import com.liangwei.tradingsystem.dto.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    public Portfolio populatePortfolio(List<Position> positionList) {
        Portfolio portfolio = new Portfolio();
        positionList.forEach(position -> {

        });

        return portfolio;
    }
}
