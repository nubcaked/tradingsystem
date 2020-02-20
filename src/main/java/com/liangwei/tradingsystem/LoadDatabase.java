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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //TODO: redo the list of data to be loaded into the db based on eurexchange.com's list

        Security s1 = new Security("GOOG", "stock", 1528.38, 0.2, 0.1);
        securityRepository.save(s1);

        Security s2 = new Security("AAPL", "stock", 324.95, 0.3, 0.3);
        securityRepository.save(s2);

        Security s3 = new Security("BABA", "stock", 219.63, 0.55, 0.2);
        securityRepository.save(s3);

        Security o1 = new Security("GOOG200417C01500000", "call", null, null, null, 1500.00, simpleDateFormat.format(new GregorianCalendar(2020, 3, 17, 5, 0, 0).getTime()));
        securityRepository.save(o1);

        Security o2 = new Security("AAPL200619C00075000", "call", null, null, null, 75.00, simpleDateFormat.format(new GregorianCalendar(2020, 5, 19, 5, 0, 0).getTime()));
        securityRepository.save(o2);

        Security o3 = new Security("BABA200918P00220000", "put", null, null, null, 220.00, simpleDateFormat.format(new GregorianCalendar(2020, 8, 18, 5, 0, 0).getTime()));
        securityRepository.save(o3);

        System.out.println("Finished populating securities database.");
    }

}
