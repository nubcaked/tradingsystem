package com.liangwei.tradingsystem.dataprovider;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import com.liangwei.tradingsystem.service.SecurityService;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Component
public class DataSubscriber {

    @Autowired
    EventBus eventBus;

    @Autowired
    SecurityRepository securityRepository;

    @Autowired
    public void registerEventListener(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void stockPriceSubscribe(Security security) {
        System.out.println("Security{ticker=" + security.getTicker() + ", price=" + security.getPrice() + "}");
    }

    private double calculateOptionPrice(Security security) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Security option = securityRepository.findByTicker(security.getTicker()).get();

            double stockPrice = security.getPrice();
            double standardDeviation = security.getStandardDeviation();
            double strikePrice = option.getStrikePrice();
            double interestRate = 0.02;
            long timeToMaturity = (simpleDateFormat.parse(option.getMaturityDate()).getTime() - new GregorianCalendar().getTimeInMillis()) / 31536000000L; // 1000 * 60 * 60 * 24 * 365 = 31536000000
            double d1 = (Math.log(stockPrice / strikePrice) + (interestRate + Math.pow(standardDeviation, 2) / 2) * timeToMaturity) / (standardDeviation * Math.sqrt(timeToMaturity));
            double d2 = d1 - (standardDeviation * Math.sqrt(timeToMaturity));

            double callOptionPrice = (stockPrice * new NormalDistribution().cumulativeProbability(d1)) - (strikePrice * Math.exp(-interestRate * timeToMaturity) * new NormalDistribution().cumulativeProbability(d2));
            

        } catch (Exception e) {}

        return 1.1;
    }

}
