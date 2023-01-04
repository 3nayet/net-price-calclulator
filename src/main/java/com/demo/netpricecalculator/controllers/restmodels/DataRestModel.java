package com.demo.netpricecalculator.controllers.restmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataRestModel {
    @JsonProperty("ok")
    private boolean ok;
    @JsonProperty("error_message")
    private String errMessage;

    public DataRestModel (boolean ok, String errMessage) {
        this.ok = ok;
        this.errMessage = errMessage;
    }

    public boolean isOk () {
        return ok;
    }

    public void setOk (boolean ok) {
        this.ok = ok;
    }

    public String getErrMessage () {
        return errMessage;
    }

    public void setErrMessage (String errMessage) {
        this.errMessage = errMessage;
    }
}
