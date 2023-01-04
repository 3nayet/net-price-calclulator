package com.demo.netpricecalculator.domain.services;

import com.demo.netpricecalculator.domain.datamodels.AvailableCountriesEntity;
import com.demo.netpricecalculator.domain.datamodels.NetPriceEntity;
import com.demo.netpricecalculator.domain.datamodels.VatEntity;
import com.demo.netpricecalculator.domain.ports.inbound.PriceService;
import com.demo.netpricecalculator.domain.ports.outbound.TaxProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    TaxProvider taxProvider;
    private final static int DEFAULT_SCALE = 2;

    @Override
    public NetPriceEntity calculateNetPrice (BigDecimal grossPrice, String country) {
        VatEntity vatEntity = this.taxProvider.getVat(country);
        if(!vatEntity.isOk()){
            return new NetPriceEntity(false, vatEntity.getErrMessage(), null);
        }
        if(grossPrice == null || grossPrice.compareTo(new BigDecimal(0))  < 0){
            return new NetPriceEntity(false,
                    "Wrong gross price, it should be greater than or equal to zero", null);
        }
        BigDecimal netPrice =  grossPrice.multiply(BigDecimal.valueOf(1 - vatEntity.getVat())
                .setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_EVEN));
        return new NetPriceEntity(true, "", netPrice);
    }

    @Override
    public AvailableCountriesEntity getAvailableCountries () {
        return taxProvider.getAvailableCountries();
    }
}
