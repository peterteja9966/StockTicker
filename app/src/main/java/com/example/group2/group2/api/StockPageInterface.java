package com.example.group2.group2.api;

import com.example.group2.group2.model.StockDetailResponse;
import com.example.group2.group2.model.StockDetails;
import com.example.group2.group2.model.response.StockQuoteResponse;

import java.util.HashMap;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface StockPageInterface {
    @GET("query")
    Observable<Response<StockDetails>> getStockDetailData(@Query("function") String order,
                                                          @Query("symbol") String page,
                                                          @Query("apikey") String apikey);

    @GET("query")
    Observable<Response<StockQuoteResponse>> getBatchStock(@QueryMap HashMap<String, String> map);
}
