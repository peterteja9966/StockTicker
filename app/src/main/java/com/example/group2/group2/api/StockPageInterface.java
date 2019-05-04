package com.example.group2.group2.api;

import com.example.group2.group2.model.response.StockQuoteResponse;

import java.util.HashMap;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface StockPageInterface {
    @GET("")
    Observable<Response<String>> getStockPageData();

    @GET("")
    Observable<Response<StockQuoteResponse>> getBatchStock(@QueryMap HashMap<String, String> map);
}
