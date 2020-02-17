package com.liangwei.tradingsystem;

import com.liangwei.tradingsystem.entity.DataProviderFlag;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.standard.ShellComponent;

//TODO: Try using @Configuration
@ShellComponent
public class DataProviderConfig {

    @Bean
    DataProviderFlag dataProviderFlag() {
        return new DataProviderFlag(false);
    }
}
