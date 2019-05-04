package com.example.group2.group2.api;

import com.example.group2.group2.network.NetworkManager;

import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;
import rx.schedulers.Schedulers;

public class StockApiManager extends NetworkManager {
    public Observable<Response<String>> getLandingPageData(String pageKey, boolean requiresAuthentication) {

        StockPageInterface service = retrofit.create(StockPageInterface.class);
        return service.getStockPageData()
                .subscribeOn(Schedulers.io());
    }

    public interface StockPageInterface {
        @POST("")
        Observable<Response<String>> getStockPageData();
    }
}
