package com.example.group2.group2.api;

import com.example.group2.group2.model.StockDetailResponse;
import com.example.group2.group2.model.StockDetails;
import com.example.group2.group2.model.request.StockQuoteRequest;
import com.example.group2.group2.model.response.StockQuoteResponse;
import com.example.group2.group2.network.NetworkManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

import retrofit2.Response;
import retrofit2.http.Query;
import rx.Observable;
import rx.schedulers.Schedulers;

public class StockApiManager extends NetworkManager {

    StockPageInterface service;

    public StockApiManager(String baseUrl) {
        super(baseUrl);
        service = retrofit.create(StockPageInterface.class);
    }

    /*
     * Call get Batch Stock
     * */
    public Observable<Response<StockQuoteResponse>> getBatchStock(StockQuoteRequest stockQuoteRequest) {
        HashMap<String, String> keyValues = new Gson().fromJson(new Gson().toJson(stockQuoteRequest),
                new TypeToken<HashMap<String, String>>() {
                }.getType()
        );
        return service.getBatchStock(keyValues)
                .subscribeOn(Schedulers.io());
    }

    public Observable<Response<StockDetails>> getDetailsStockData(String function,
                                                                  String page,
                                                                  String apikey) {
        return service.getStockDetailData(function, page, apikey)
                .subscribeOn(Schedulers.io());
    }


}