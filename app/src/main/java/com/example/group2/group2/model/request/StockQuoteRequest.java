package com.example.group2.group2.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockQuoteRequest extends BaseRequest {

    @SerializedName("symbols")
    @Expose
    private String symbols = "";

    @Override
    String setFunction() {
        return "BATCH_STOCK_QUOTES";
    }

    public String getSymbols() {
        return symbols;
    }

    public void setSymbols(String symbols) {
        this.symbols = symbols;
    }
}
