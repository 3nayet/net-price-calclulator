package com.demo.netpricecalculator.domain.datamodels;

import java.math.BigDecimal;

public class NetPriceEntity extends DataEntity{
    private BigDecimal netPrice;

    public NetPriceEntity (boolean ok, String errMessage, BigDecimal netPrice) {
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
