package com.demo.netpricecalculator.domain.datamodels;

import java.util.List;

public class AvailableCountriesEntity extends DataEntity{
    private List<CountryEntity> countires;

    public AvailableCountriesEntity (boolean ok, String errMessage, List<CountryEntity> countires) {
        super(ok, errMessage);
        this.countires = countires;
    }

    public List<CountryEntity> getCountires () {
        return countires;
    }

    public void setCountires (List<CountryEntity> countires) {
        this.countires = countires;
    }
}
