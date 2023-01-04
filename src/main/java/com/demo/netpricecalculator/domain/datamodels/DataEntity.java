package com.demo.netpricecalculator.domain.datamodels;

public class DataEntity {
    private boolean ok;
    private String errMessage;

    public DataEntity (boolean ok, String errMessage) {
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
