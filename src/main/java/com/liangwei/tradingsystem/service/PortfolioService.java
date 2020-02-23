package com.liangwei.tradingsystem.service;

import com.liangwei.tradingsystem.dto.Portfolio;
import com.liangwei.tradingsystem.dto.Position;
import com.liangwei.tradingsystem.entity.Security;
import com.liangwei.tradingsystem.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    SecurityRepository securityRepository;

    public Portfolio populatePortfolio(List<Position> positionList) {
        Portfolio portfolio = new Portfolio();
//        List<Security> securityList = new ArrayList<>();
//        double netAssetValue = 0.0;
        positionList.forEach(position -> {
            Security security = securityRepository.findByTicker(position.getTicker()).get();
            position.setMarketValue(security.getPrice() * position.getQuantity());
            //TODO: map security to securityDTO so can print individual position market value
            portfolio.getPositionList().add(position);
            portfolio.setNetAssetValue(portfolio.getNetAssetValue() + position.getMarketValue());
        });

        return portfolio;
    }
}
