package com.demo.netpricecalculator.controllers.restmodels;

import com.demo.netpricecalculator.domain.datamodels.CountryEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AvailableCountriesRestModel extends DataRestModel{
    @JsonProperty("country_list")
    private List<CountryEntity> countries;

    public AvailableCountriesRestModel (boolean ok, String errMessage, List<CountryEntity> countries) {
        super(ok, errMessage);
        this.countries = countries;
    }

    public List<CountryEntity> getCountries () {
        return countries;
    }

    public void setCountries (List<CountryEntity> countries) {
        this.countries = countries;
    }
}
