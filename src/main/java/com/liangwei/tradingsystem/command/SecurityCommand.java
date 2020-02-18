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

    @ShellMethod("Load H2 database with data")
    public String getSecurities() throws Exception {
        return securityService.displaySecurities();
    }

    @ShellMethod("Test")
    public String test() throws Exception {
        Date date = new SimpleDateFormat("yyyyMMdd kkmmss").parse("20200220 050000");
        Calendar date2 = new GregorianCalendar(2020, 0, 20, 05, 00, 00);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int x = ThreadLocalRandom.current().nextInt(1, 3);
        return "" + x;
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
