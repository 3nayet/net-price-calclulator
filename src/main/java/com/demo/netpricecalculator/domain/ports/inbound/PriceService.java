package com.demo.netpricecalculator.domain.ports.inbound;

import com.demo.netpricecalculator.domain.datamodels.AvailableCountriesEntity;
import com.demo.netpricecalculator.domain.datamodels.NetPriceEntity;

import java.math.BigDecimal;

public interface PriceService {

    NetPriceEntity calculateNetPrice(BigDecimal grossPrice, String country);
    AvailableCountriesEntity getAvailableCountries();
}
