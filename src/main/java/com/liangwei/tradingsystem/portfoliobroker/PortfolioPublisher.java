package com.liangwei.tradingsystem.portfoliobroker;

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.EventBus;
import com.liangwei.tradingsystem.DataProviderFlag;
import com.liangwei.tradingsystem.dto.Portfolio;
import com.liangwei.tradingsystem.dto.Position;
import com.liangwei.tradingsystem.service.PortfolioService;
import com.liangwei.tradingsystem.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class PortfolioPublisher {

    @Autowired
    EventBus eventBus;

    @Autowired
    PositionService positionService;

    @Autowired
    PortfolioService portfolioService;

    @Autowired
    DataProviderFlag dataProviderFlag;

    @Async
    public void publishPortfolio() {
        try {
            List<Position> positionList = positionService.getPositions("positions.csv");

            while (dataProviderFlag.isRunFlag()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}
                Portfolio portfolio = portfolioService.populatePortfolio(positionList);
                System.out.println(portfolio); //TODO: publish instead of printing
            }
        } catch (IOException e) {}
    }

}
