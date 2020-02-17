package com.liangwei.tradingsystem.dataprovider;

import com.google.common.eventbus.EventBus;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.shell.standard.ShellComponent;

import java.util.List;

@ShellComponent
public class DataProvider {

    @Autowired
    EventBus eventBus;

    @Autowired
    SecurityService securityService;



    @Async
    public void moveStockPrice(Security security) throws InterruptedException {
        int x = 0;
        while (x < 10) {
            Thread.sleep(1000);
            eventBus.post("hihi hoho");
            x++;
        }
    }
}
