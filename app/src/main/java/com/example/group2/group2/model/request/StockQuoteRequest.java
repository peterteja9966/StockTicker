package com.example.group2.group2.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockQuoteRequest extends BaseRequest {

    @SerializedName("symbols")
    @Expose
    private String symbols = "MSFT,AAPL,FB,HON";

    @Override
    String setFunction() {
        return "BATCH_STOCK_QUOTES";
    }
}
