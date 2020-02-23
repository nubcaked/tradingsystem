package com.liangwei.tradingsystem;

import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Configuration
public class LoadDatabase {

    @Autowired
    SecurityRepository securityRepository;

    @Bean
    public void populateSecurities() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Security s1 = new Security("AKZA", "stock", 84.32, 0.07, 4.18);
        securityRepository.save(s1);

        Security s2 = new Security("HFG.DE", "stock", 24.0, 1.72, 5.09);
        securityRepository.save(s2);

        Security s3 = new Security("RACE.MI", "stock", 159.8, 0.48, 13.23);
        securityRepository.save(s3);

        Security o1 = new Security("NL0013267909", "call", 12.6, null, null, 72.0, simpleDateFormat.format(new GregorianCalendar(2020, Calendar.JUNE, 19, 3, 0, 0).getTime()), "AKZA");
        securityRepository.save(o1);

        Security o2 = new Security("DE000A161408", "put", 7.82, null, null, 30.0, simpleDateFormat.format(new GregorianCalendar(2020, Calendar.DECEMBER, 25, 3, 0, 0).getTime()), "HFG.DE");
        securityRepository.save(o2);

        Security o3 = new Security("NL0011585146", "call", 40.7, null, null, 120.0, simpleDateFormat.format(new GregorianCalendar(2020, Calendar.SEPTEMBER, 18, 3, 0, 0).getTime()), "RACE.MI");
        securityRepository.save(o3);

        System.out.println("Finished populating securities database.");
    }

}
