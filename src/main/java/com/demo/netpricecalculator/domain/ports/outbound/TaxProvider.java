package com.demo.netpricecalculator.domain.ports.outbound;

import com.demo.netpricecalculator.domain.datamodels.AvailableCountriesEntity;
import com.demo.netpricecalculator.domain.datamodels.VatEntity;

public interface TaxProvider {
    VatEntity getVat(String country);
    AvailableCountriesEntity getAvailableCountries();
}
