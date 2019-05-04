package com.example.group2.group2.view.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.group2.group2.BuildConfig;
import com.example.group2.group2.R;
import com.example.group2.group2.model.StockDetailResponse;
import com.example.group2.group2.model.response.StockQuote;
import com.example.group2.group2.presenter.HomePresenter;
import com.example.group2.group2.view.home.HomeFragment;
import com.example.group2.group2.view.home.IHome;

import java.util.ArrayList;

public class StockDetailActivity extends AppCompatActivity implements IHome {


    HomePresenter homePresenter;
    TextView price, symbol,timeZone, firstCharacter, openvalue, marketCapValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_home_list_item);
        String symbol= getIntent().getStringExtra("symbol");
        homePresenter = new HomePresenter(this);
        homePresenter.getDetailsStockData(symbol);
        init();

    }

    private void init() {
        price = findViewById(R.id.num_usd_text);
        symbol = findViewById(R.id.sym_txt);
        timeZone = findViewById(R.id.time_zone_txt);
        firstCharacter = findViewById(R.id.firstCharacter);
        openvalue = findViewById(R.id.open_txt_value);
        marketCapValue = findViewById(R.id.market_cap_value);
    }


    @Override
    public void loadStockQuotesSuccess(ArrayList<StockQuote> stockQuotes) {

    }

    @Override
    public void loadStockQuotesFailed() {

    }

    @Override
    public void loadStockDetailData(StockDetailResponse detailResponse) {
        price.setText(detailResponse.getPrice());
        symbol.setText(detailResponse.getSymbol());
        timeZone.setText(detailResponse.getLatestTradingDay());
        firstCharacter.setText(detailResponse.getSymbol().substring(0,1));
        openvalue.setText(detailResponse.getPrice());
        marketCapValue.setText(detailResponse.getPrice());
    }

    @Override
    public void showProgress(boolean show) {

    }


}
