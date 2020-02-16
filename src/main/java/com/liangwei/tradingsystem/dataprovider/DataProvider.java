package com.liangwei.tradingsystem.dataprovider;

import com.google.common.eventbus.EventBus;
import com.liangwei.tradingsystem.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class DataProvider {

    @Autowired
    EventBus eventBus;

    @Autowired
    SecurityService securityService;

    @Bean
    @Async
    public void startPriceGenerator() {

    }

    @Async
    public void dispatchEvent() throws InterruptedException {
        int x = 0;
        while (x < 10) {
            Thread.sleep(1000);
            eventBus.post("hihi hoho");
            x++;
        }
    }
}
