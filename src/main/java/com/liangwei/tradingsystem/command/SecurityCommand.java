package com.liangwei.tradingsystem.command;

import com.google.common.eventbus.EventBus;
import com.liangwei.tradingsystem.DataProviderFlag;
import com.liangwei.tradingsystem.dto.Portfolio;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.portfoliobroker.PortfolioPublisher;
import com.liangwei.tradingsystem.service.PortfolioService;
import com.liangwei.tradingsystem.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class SecurityCommand {

    @Autowired
    SecurityService securityService;

    @Autowired
    DataProviderFlag dataProviderFlag;

    @Autowired
    PortfolioService portfolioService;

    @Autowired
    EventBus eventBus;

    @ShellMethod("Displays data in the H2 database")
    public String getSecurities() throws Exception {
        return securityService.displaySecurities();
    }

    @ShellMethod("Simulate price movement for all stocks")
    public void startPriceMovements() {
        List<Security> securityList = securityService.getStockPriceList();
        Portfolio portfolio = portfolioService.instantiatePortfolio("positions.csv");

        dataProviderFlag.setRunFlag(true);

        PortfolioPublisher portfolioPublisher = new PortfolioPublisher(portfolio, eventBus);
        eventBus.register(portfolioPublisher);

        securityList.forEach(security -> securityService.moveStockPrice(security));
    }

    @ShellMethod("Stop price movement for all stocks")
    public void stopPriceMovements() {
        dataProviderFlag.setRunFlag(false);
    }

}
