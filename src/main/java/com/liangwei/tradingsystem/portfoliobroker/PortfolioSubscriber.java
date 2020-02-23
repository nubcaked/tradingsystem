package com.liangwei.tradingsystem.portfoliobroker;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.liangwei.tradingsystem.dto.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PortfolioSubscriber {
    @Autowired
    public void registerEventListener(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void portfolioSubscriber(Portfolio portfolio) {
        System.out.println(portfolio);
    }
}
