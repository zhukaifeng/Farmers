package com.osiris.farmers.event;

public class MarketCXEvent {

    private String marketName;
    private int marketId;

    public MarketCXEvent(String marketName, int marketId) {
        this.marketName = marketName;
        this.marketId = marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }
}
