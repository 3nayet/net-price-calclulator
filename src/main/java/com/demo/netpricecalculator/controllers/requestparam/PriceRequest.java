package com.demo.netpricecalculator.controllers.requestparam;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class PriceRequest {

    @NotBlank
    private String country;

    @NotBlank
    private BigDecimal price;

    public String getCountry () {
        return country;
    }

    public void setCountry (String country) {
        this.country = country;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice (BigDecimal price) {
        this.price = price;
    }
}
