package com.liangwei.tradingsystem.portfoliobroker;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PortfolioPublisher {

    @Autowired
    EventBus eventBus;


}
