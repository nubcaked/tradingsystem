package com.liangwei.tradingsystem.service;

import com.liangwei.tradingsystem.dto.Portfolio;
import com.liangwei.tradingsystem.dto.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    PositionService positionService;

    public Portfolio instantiatePortfolio(String positionsFile) {
        Portfolio portfolio = new Portfolio();
        try {
            List<Position> positionList = positionService.getPositions(positionsFile);
            positionList.forEach(position -> portfolio.getPositionMap().put(position.getTicker(), position));
        } catch (IOException e) {}

        return portfolio;
    }
}
