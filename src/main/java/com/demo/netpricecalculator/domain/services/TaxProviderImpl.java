package com.demo.netpricecalculator.domain.services;

import com.demo.netpricecalculator.domain.datamodels.AvailableCountriesEntity;
import com.demo.netpricecalculator.domain.datamodels.CountryEntity;
import com.demo.netpricecalculator.domain.datamodels.VatEntity;
import com.demo.netpricecalculator.domain.ports.outbound.TaxProvider;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.Map.entry;

@Service
public class TaxProviderImpl implements TaxProvider {
    Map<CountryEntity, Number> vatRates= Map.ofEntries(
            entry(new CountryEntity("DE", "Germany"), 0.19),
            entry(new CountryEntity("FR", "France"), .2),
            entry(new CountryEntity("IT", "Italy"), .21),
            entry(new CountryEntity("UK", "United Kingdom"), .23),
            entry(new CountryEntity("ES", "Spain"), .24),
            entry(new CountryEntity("PG", "Portugal"), .25),
            entry(new CountryEntity("NL", "Netherlands"), .26),
            entry(new CountryEntity("US", "United States"), .27),
            entry(new CountryEntity("SZ", "Switzerland"), .28),
            entry(new CountryEntity("CA", "Canada"), .29),
            entry(new CountryEntity("BG", "Belgium"), .29),
            entry(new CountryEntity("SW", "Sweden"), .3)
    );
    @Override
    public VatEntity getVat (String country) {
        if(country == null || vatRates.keySet().stream().noneMatch(c -> c.getCode().equals(country.toUpperCase()))){
            return new VatEntity(false, "Country is not provided in our VAT scheme" , null);
        }
        return new VatEntity(true, "",
                vatRates.entrySet().stream().filter(c -> c.getKey().getCode().equals(country.toUpperCase())).
                        findFirst().get().getValue().floatValue());
    }

    @Override
    public AvailableCountriesEntity getAvailableCountries () {
        return new AvailableCountriesEntity(true, "", vatRates.keySet().stream().toList());
    }
}
