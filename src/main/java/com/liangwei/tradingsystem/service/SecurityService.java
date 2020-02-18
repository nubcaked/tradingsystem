package com.liangwei.tradingsystem.service;

import com.google.common.base.Joiner;
import com.google.common.eventbus.EventBus;
import com.liangwei.tradingsystem.entity.DataProviderFlag;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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
    DataProviderFlag dataProviderFlag;

    public String displaySecurities() {
        List<Security> securityList = securityRepository.findAll();
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

    @Async
    public void moveStockPrice(Security security) {
        while (dataProviderFlag.isRunFlag()) {
            //TODO: Use eventBus to publish messages.
            double price = security.getPrice();
            int deltaTime = ThreadLocalRandom.current().nextInt(500, 1501);
            double deltaTimeSeconds = deltaTime / 1000.0;
            double expectedReturn = security.getExpectedReturn();
            double standardDeviation = security.getStandardDeviation();
            double standardNormalDistribution = new NormalDistribution(0, 1).sample();

            double deltaPrice = price * (expectedReturn * deltaTimeSeconds / 7257600 + standardDeviation * standardNormalDistribution * Math.sqrt(deltaTimeSeconds / 7257600));
            double newPrice = price + deltaPrice;
            try {
                Thread.sleep(deltaTime);
                security.setPrice(newPrice);
                securityRepository.save(security);
                if (security.getTicker().equals("GOOG")) {
                    System.out.println(security.getPrice());
                }
            } catch (InterruptedException e) {}
//            System.out.println("hihi hoho " + security.getTicker());
//            eventBus.post("hihi hoho " + security.getTicker());
        }
    }

}
