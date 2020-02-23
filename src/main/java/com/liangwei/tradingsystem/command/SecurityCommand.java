package com.liangwei.tradingsystem.command;

import com.google.common.eventbus.EventBus;
import com.liangwei.tradingsystem.dto.Portfolio;
import com.liangwei.tradingsystem.portfoliobroker.PortfolioPublisher;
import com.liangwei.tradingsystem.portfoliobroker.PortfolioSubscriber;
import com.liangwei.tradingsystem.DataProviderFlag;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import com.liangwei.tradingsystem.service.PortfolioService;
import com.liangwei.tradingsystem.service.PositionService;
import com.liangwei.tradingsystem.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@ShellComponent
public class SecurityCommand {

    @Autowired
    SecurityRepository securityRepository;

    @Autowired
    SecurityService securityService;

    @Autowired
    DataProviderFlag dataProviderFlag;

    @Autowired
    PortfolioSubscriber portfolioSubscriber;

    @Autowired
    PositionService positionService;

    @Autowired
    PortfolioService portfolioService;

    @Autowired
    EventBus eventBus;

//    @Autowired
//    PortfolioPublisher portfolioPublisher;

    @ShellMethod("Load H2 database with data")
    public String getSecurities() throws Exception {
        return securityService.displaySecurities();
    }

    @ShellMethod("Test")
    public String test() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("20200220 050000");
        Calendar date2 = new GregorianCalendar(2020, 0, 20, 05, 00, 00);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int x = ThreadLocalRandom.current().nextInt(1, 3);
//        return sdf.format(date2.getTime());
//        return Math.log1p(12) + " " + Math.log(12);
//        return securityRepository.findByTicker("GOOG").get().getPrice().toString();
//        return simpleDateFormat.format(new GregorianCalendar().getTime());
//        return Math.exp(-12) + "";
//        portfolioPublisher.publishPortfolio();
        return "";
    }

    @ShellMethod("Simulate price movement for all stocks")
    public void startPriceMovements() {
        List<Security> securityList = securityService.getStockPriceList();
        dataProviderFlag.setRunFlag(true);
        PortfolioPublisher portfolioPublisher = new PortfolioPublisher(new Portfolio());
        eventBus.register(portfolioPublisher);
        //TODO: by making PortfolioPublisher non-singleton, i can generate one instance for each portfolio and listen to stock price update and
        //TODO: update portfolio and publish portfolio
//        portfolioPublisher.publishPortfolio();
        securityList.forEach(security -> securityService.moveStockPrice(security));
    }

    @ShellMethod("Stop price movement for all stocks")
    public void stopPriceMovements() {
        dataProviderFlag.setRunFlag(false);
    }

}
