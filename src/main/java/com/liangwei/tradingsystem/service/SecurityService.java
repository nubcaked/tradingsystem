package com.liangwei.tradingsystem.service;

import com.google.common.base.Joiner;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SecurityService {

    @Autowired
    SecurityRepository securityRepository;

    public String displaySecurities() {
        List<Security> securityList = securityRepository.findAll();
        String result = Joiner.on("\n").join(securityList);
        return result;
    }

    public Map<String, Double> getStockPriceMap() {
        List<Security> securityList = securityRepository.findAll();
        Map<String, Double> result = securityList.stream()
                .filter(s -> s.getType().equals("stock"))
                .collect(Collectors.toMap(Security::getTicker, Security::getPrice));

        System.out.println(result.keySet());
        System.out.println(result.values());

        return result;
    }

}
