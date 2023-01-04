package com.demo.netpricecalculator.domain.datamodels;

public class VatEntity extends DataEntity{
    private Float vat;

    public VatEntity (boolean ok, String errMessage, Float vat) {
        super(ok, errMessage);
        this.vat = vat;
    }

    public Float getVat () {
        return vat;
    }

    public void setVat (Float vat) {
        this.vat = vat;
    }
}
