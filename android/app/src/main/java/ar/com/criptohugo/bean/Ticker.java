package ar.com.criptohugo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Ticker... information about an specific Crytocurrency
 * Created by dmernies on 6/3/18.
 */

public class Ticker {
    private String id;
    private String name;
    private String symbol;
    private String rank;
    private String priceUsd;
    private String priceBtc;
    private String v24hVolumeUsd;
    private String marketCapUsd;
    private String availableSupply;
    private String totalSupply;
    private String percentChange1h;
    private String percentChange24h;
    private String percentChange7d;
    private String lastUpdated;
    private String maxSupply;

    public Ticker(){
        super();
    }

    public Ticker(String priceUsd, String priceBtc) {
        super();
        this.priceBtc = priceBtc;
        this.priceUsd = priceUsd;
    }

    @JsonProperty("max_supply")
    public String getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(String maxSupply) {
        this.maxSupply = maxSupply;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("rank")
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @JsonProperty("price_usd")
    public String getPriceUsd() {
        return priceUsd;
    }

    @JsonIgnore
    public BigDecimal getPriceUsdBigDecimal(){
        return new BigDecimal(this.priceUsd);
    }
    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    @JsonProperty("price_btc")
    public String getPriceBtc() {
        return priceBtc;
    }
    @JsonIgnore
    public BigDecimal getPriceBTCBigDecimal(){
        return new BigDecimal(this.priceBtc);
    }
    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    @JsonProperty("24h_volume_usd")
    public String getV24hVolumeUsd() {
        return v24hVolumeUsd;
    }

    public void setV24hVolumeUsd(String v24hVolumeUsd) {
        this.v24hVolumeUsd = v24hVolumeUsd;
    }

    @JsonProperty("market_cap_usd")
    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    @JsonProperty("available_supply")
    public String getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(String availableSupply) {
        this.availableSupply = availableSupply;
    }

    @JsonProperty("total_supply")
    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    @JsonProperty("percent_change_1h")
    public String getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(String percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    @JsonProperty("percent_change_24h")
    public String getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(String percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    @JsonProperty("percent_change_7d")
    public String getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(String percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    @JsonProperty("last_updated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticker ticker = (Ticker) o;

        return id.equals(ticker.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
