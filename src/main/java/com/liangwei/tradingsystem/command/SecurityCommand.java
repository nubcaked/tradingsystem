package com.liangwei.tradingsystem.command;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import com.liangwei.tradingsystem.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Map;

@ShellComponent
public class SecurityCommand {

    @Autowired
    SecurityRepository securityRepository;

    @Autowired
    SecurityService securityService;

    @ShellMethod("Load H2 database with data")
    public String getSecurities() throws Exception {
        return securityService.displaySecurities();
    }

//    @Autowired
//    public void RegisterEventListener(EventBus eventBus) {
//        eventBus.register(this);
//    }

    @Subscribe
    public void onTestEvent(String string) {
        System.out.println("Received:");
        System.out.println(string);
    }

}
