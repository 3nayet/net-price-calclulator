package com.demo.netpricecalculator.controllers.restmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class NetPriceRestModel extends DataRestModel{
    @JsonProperty("net_price")
    private BigDecimal netPrice;

    public NetPriceRestModel (boolean ok, String errMessage, BigDecimal netPrice) {
        super(ok, errMessage);
        this.netPrice = netPrice;
    }

    public BigDecimal getNetPrice () {
        return netPrice;
    }

    public void setNetPrice (BigDecimal netPrice) {
        this.netPrice = netPrice;
    }
}
