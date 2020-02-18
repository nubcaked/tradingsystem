package com.liangwei.tradingsystem;

import com.liangwei.tradingsystem.entity.DataProviderFlag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataProviderConfig {

    @Bean
    DataProviderFlag dataProviderFlag() {
        return new DataProviderFlag(false);
    }
}
