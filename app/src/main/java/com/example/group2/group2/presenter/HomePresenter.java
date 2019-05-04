package com.example.group2.group2.presenter;

import com.example.group2.group2.api.StockApiManager;
import com.example.group2.group2.model.StockDetails;
import com.example.group2.group2.model.request.StockQuoteRequest;
import com.example.group2.group2.model.response.StockQuoteResponse;
import com.example.group2.group2.view.home.IHome;

import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomePresenter {

    StockApiManager stockApiManager;
    String baseUrl = "https://www.alphavantage.co/";
    IHome iHome;

    public HomePresenter(IHome iHome) {
        this.stockApiManager = new StockApiManager(baseUrl);
        this.iHome = iHome;
    }

    public void getStockData(String symbols) {
        StockQuoteRequest stockQuoteRequest = new StockQuoteRequest();
        stockQuoteRequest.setSymbols(symbols);
        stockApiManager.getBatchStock(stockQuoteRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<StockQuoteResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iHome.loadStockQuotesFailed();
                    }

                    @Override
                    public void onNext(Response<StockQuoteResponse> stockQuoteResponseResponse) {
                        if (stockQuoteResponseResponse != null && stockQuoteResponseResponse.isSuccessful()) {
                            iHome.loadStockQuotesSuccess(stockQuoteResponseResponse.body().getStockQuotes());
                        } else {
                            iHome.loadStockQuotesFailed();
                        }
                    }
                });
    }


    public void getDetailsStockData(String symbol) {
        stockApiManager.getDetailsStockData("GLOBAL_QUOTE", symbol, "BZ4EFVGM2D4OXBJM")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<StockDetails>>() {
                    @Override
                    public void onCompleted() { }

                    @Override
                    public void onError(Throwable e) {
                        iHome.loadStockQuotesFailed();
                    }

                    @Override
                    public void onNext(Response<StockDetails> stockDetailResponse) {
                        if (stockDetailResponse != null && stockDetailResponse.isSuccessful()) {
                            iHome.loadStockDetailData(stockDetailResponse.body().getGlobalQuote());
                        } else {
                           // iHome.loadStockQuotesFailed();
                        }
                    }
                });
    }

}
