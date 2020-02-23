package com.liangwei.tradingsystem.portfoliobroker;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.liangwei.tradingsystem.dto.Portfolio;
import com.liangwei.tradingsystem.dto.Position;
import com.liangwei.tradingsystem.entity.Security;

public class PortfolioPublisher {

    private Portfolio portfolio;
    private EventBus eventBus;

    public PortfolioPublisher(Portfolio portfolio, EventBus eventBus) {
        this.portfolio = portfolio;
        this.eventBus = eventBus;
    }


    @Subscribe
    public void updatePortfolio(Security security) {
        if (portfolio.getPositionMap().containsKey(security.getTicker())) {
            Position position = portfolio.getPositionMap().get(security.getTicker());
            position.setMarketValue(security.getPrice() * position.getQuantity());
            portfolio.setNetAssetValue(portfolio.getNetAssetValue() + position.getMarketValue());
            eventBus.post(portfolio);
        }
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }
}
