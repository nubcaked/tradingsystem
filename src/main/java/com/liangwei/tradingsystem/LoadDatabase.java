package com.liangwei.tradingsystem;

import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.standard.ShellComponent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

@Configuration
public class LoadDatabase {

    @Autowired
    SecurityRepository securityRepository;

    @Bean
    public void populateSecurities() throws ParseException {
        Security s1 = new Security("GOOG", "stock", 1518.73, 0.2, 0.1);
        securityRepository.save(s1);

        Security s2 = new Security("AAPL", "stock", 324.95, 0.3, 0.3);
        securityRepository.save(s2);

        Security s3 = new Security("BABA", "stock", 219.63, 0.55, 0.2);
        securityRepository.save(s3);

        Security o1 = new Security("GOOGFEB20C1520", "call", null, null, null, 1520.00, new GregorianCalendar(2020, 01, 20, 05, 00, 00));
        securityRepository.save(o1);

        Security o2 = new Security("AAPLFEB20C335", "call", null, null, null, 335.00, new GregorianCalendar(2020, 01, 20, 05, 00, 00));
        securityRepository.save(o2);

        Security o3 = new Security("BABAFEB20C235", "call", null, null, null, 235.00, new GregorianCalendar(2020, 01, 20, 05, 00, 00));
        securityRepository.save(o3);

        System.out.println("Finished populating securities database.");
    }

}
