package com.liangwei.tradingsystem.command;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.liangwei.tradingsystem.dataprovider.DataProvider;
import com.liangwei.tradingsystem.entity.DataProviderFlag;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import com.liangwei.tradingsystem.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.Map;

@ShellComponent
public class SecurityCommand {

    @Autowired
    SecurityRepository securityRepository;

    @Autowired
    SecurityService securityService;

    @Autowired
    DataProviderFlag dataProviderFlag;

    @ShellMethod("Load H2 database with data")
    public String getSecurities() throws Exception {
        return securityService.displaySecurities();
    }

    @ShellMethod("Test")
    public String test() throws Exception {
        securityService.getStockPriceList();
        return "";
    }

    @ShellMethod("Simulate price movement for all stocks")
    public void startPriceMovements() {
        List<Security> securityList = securityService.getStockPriceList();
        dataProviderFlag.setRunFlag(true);
        securityList.forEach(security -> securityService.moveStockPrice(security));
    }

    @ShellMethod("Stop price movement for all stocks")
    public void stopPriceMovements() {
        dataProviderFlag.setRunFlag(false);
    }

    @Autowired
    public void RegisterEventListener(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void onTestEvent(String string) {
        System.out.println("Received:");
        System.out.println(string);
    }

}
