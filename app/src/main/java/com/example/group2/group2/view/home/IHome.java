package com.example.group2.group2.view.home;

import com.example.group2.group2.model.StockDetailResponse;
import com.example.group2.group2.model.response.StockQuote;

import java.util.ArrayList;

public interface IHome {
    void loadStockQuotesSuccess(ArrayList<StockQuote> stockQuotes);

    void loadStockQuotesFailed();

    void loadStockDetailData(StockDetailResponse detailResponse);

    void showProgress(boolean show);
}
