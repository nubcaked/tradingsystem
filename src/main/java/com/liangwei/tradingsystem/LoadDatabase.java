package com.liangwei.tradingsystem;

import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class LoadDatabase {

    @Autowired
    SecurityRepository securityRepository;

    @Bean
    public void populateSecurities() {
        Security s1 = new Security("GOOG", "stock");
        securityRepository.save(s1);

        Security s2 = new Security("MCO", "stock");
        securityRepository.save(s2);

        Security s3 = new Security("MSFT", "stock");
        securityRepository.save(s3);
    }

}
