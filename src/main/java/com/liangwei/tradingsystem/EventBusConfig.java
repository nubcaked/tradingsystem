package com.liangwei.tradingsystem;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.standard.ShellComponent;

//TODO: Try using @Configuration
@ShellComponent
public class EventBusConfig {
    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }
}
