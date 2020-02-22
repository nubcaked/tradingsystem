package com.liangwei.tradingsystem.service;

import com.google.common.base.Joiner;
import com.google.common.eventbus.EventBus;
import com.liangwei.tradingsystem.dataprovider.DataSubscriber;
import com.liangwei.tradingsystem.entity.DataProviderFlag;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class SecurityService {

    @Autowired
    SecurityRepository securityRepository;

    @Autowired
    EventBus eventBus;

    @Autowired
    DataSubscriber dataSubscriber;

    @Autowired
    DataProviderFlag dataProviderFlag;

    public String displaySecurities() {
        List<Security> securityList = securityRepository.findAll();
        String result = Joiner.on("\n").join(securityList);
        return result;
    }

    public String displayStock() {
        List<Security> securityList = securityRepository.findAll().stream()
                .filter(security -> security.getType().equals("stock"))
                .collect(Collectors.toList());
        String result = Joiner.on("\n").join(securityList);
        return result;
    }

    public List<Security> getStockPriceList() {
        List<Security> result = securityRepository.findAll().stream()
                .filter(s -> s.getType().equals("stock"))
                .collect(Collectors.toList());

//        result.forEach(s -> System.out.println(s.getTicker()));

        return result;
    }

    //TODO: make this method call updateStockPrice() and updateOptionPrice()
    @Async
    public void moveStockPrice(Security security) {
        while (dataProviderFlag.isRunFlag()) {
            updateStockPrice(security);
            updateOptionPrice(security);
        }
    }

    public void updateStockPrice(Security stock) {
        double price = stock.getPrice();
        int deltaTime = ThreadLocalRandom.current().nextInt(500, 1501);
        double deltaTimeSeconds = deltaTime / 1000.0;
        double expectedReturn = stock.getExpectedReturn();
        double standardDeviation = stock.getStandardDeviation();
        double standardNormalDistribution = new NormalDistribution().sample();

        double deltaPrice = price * (expectedReturn * deltaTimeSeconds / 7257600 + standardDeviation * standardNormalDistribution * Math.sqrt(deltaTimeSeconds / 7257600));
        double newPrice = price + deltaPrice;
        try {
            Thread.sleep(deltaTime);
            stock.setPrice(newPrice);
            securityRepository.save(stock);
//                eventBus.post(security);
        } catch (InterruptedException e) {}
    }

    public void updateOptionPrice(Security stock) {
        try {
//            Security stock = securityRepository.findByTicker(option.getParentTicker()).get();
            String ticker = stock.getTicker();
            Security option = securityRepository.findByTicker(ticker).get(); //TODO: findByParentTicker() instead

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            double stockPrice = stock.getPrice();
            double standardDeviation = stock.getStandardDeviation();
            double strikePrice = option.getStrikePrice();
            double interestRate = 0.02;
            long timeToMaturity = (simpleDateFormat.parse(option.getMaturityDate()).getTime() - new GregorianCalendar().getTimeInMillis()) / 31536000000L; // 1000 * 60 * 60 * 24 * 365 = 31536000000
            double d1 = (Math.log(stockPrice / strikePrice) + (interestRate + Math.pow(standardDeviation, 2) / 2) * timeToMaturity) / (standardDeviation * Math.sqrt(timeToMaturity));
            double d2 = d1 - (standardDeviation * Math.sqrt(timeToMaturity));

            double callOptionPrice = (stockPrice * new NormalDistribution().cumulativeProbability(d1)) - (strikePrice * Math.exp(-interestRate * timeToMaturity) * new NormalDistribution().cumulativeProbability(d2));
            double putOptionPrice = (strikePrice * Math.exp(-interestRate * timeToMaturity) * new NormalDistribution().cumulativeProbability(-d2)) - (stockPrice * new NormalDistribution().cumulativeProbability(-d1));

            //TODO: save the option price to db
//            if (option.getType().equals("call")) {
//                return callOptionPrice;
//            } else if (option.getType().equals("put")) {
//                return putOptionPrice;
//            }
        } catch (Exception e) {}
    }

}
