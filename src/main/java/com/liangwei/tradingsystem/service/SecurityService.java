package com.liangwei.tradingsystem.service;

import com.google.common.base.Joiner;
import com.google.common.eventbus.EventBus;
import com.liangwei.tradingsystem.entity.DataProviderFlag;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            //TODO: Randomize sleep duration and stock price adhering to a certain percentage.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println("hihi hoho " + security.getTicker());
//            eventBus.post("hihi hoho " + security.getTicker());
        }
    }

}
