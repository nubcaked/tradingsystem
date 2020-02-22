package com.liangwei.tradingsystem.portfoliobroker;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PortfolioSubscriber {

    @Autowired
    EventBus eventBus;

    @Autowired
    SecurityRepository securityRepository;

    @Autowired
    public void registerEventListener(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void portfolioSubscriber(Security security) {

    }

//    public double calculateOptionPrice(String ticker) {
//        try {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            Security option = securityRepository.findByTicker(ticker).get();
//            Security stock = securityRepository.findByTicker(option.getParentTicker()).get();
//
//            double stockPrice = stock.getPrice();
//            double standardDeviation = stock.getStandardDeviation();
//            double strikePrice = option.getStrikePrice();
//            double interestRate = 0.02;
//            long timeToMaturity = (simpleDateFormat.parse(option.getMaturityDate()).getTime() - new GregorianCalendar().getTimeInMillis()) / 31536000000L; // 1000 * 60 * 60 * 24 * 365 = 31536000000
//            double d1 = (Math.log(stockPrice / strikePrice) + (interestRate + Math.pow(standardDeviation, 2) / 2) * timeToMaturity) / (standardDeviation * Math.sqrt(timeToMaturity));
//            double d2 = d1 - (standardDeviation * Math.sqrt(timeToMaturity));
//
//            double callOptionPrice = (stockPrice * new NormalDistribution().cumulativeProbability(d1)) - (strikePrice * Math.exp(-interestRate * timeToMaturity) * new NormalDistribution().cumulativeProbability(d2));
//            double putOptionPrice = (strikePrice * Math.exp(-interestRate * timeToMaturity) * new NormalDistribution().cumulativeProbability(-d2)) - (stockPrice * new NormalDistribution().cumulativeProbability(-d1));
//
//            if (option.getType().equals("call")) {
//                return callOptionPrice;
//            } else if (option.getType().equals("put")) {
//                return putOptionPrice;
//            }
//        } catch (Exception e) {}
//        return -1;
//    }

}
