package com.example.group2.group2.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.group2.group2.R;
import com.example.group2.group2.model.CompanyModel;
import com.example.group2.group2.model.StockDetailResponse;
import com.example.group2.group2.model.response.StockQuote;
import com.example.group2.group2.presenter.HomePresenter;
import com.example.group2.group2.view.detail.StockDetailActivity;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link }
 * interface.
 */
public class HomeFragment extends Fragment implements IHome, MyStockRecyclerViewAdapter.OnListClickListeners {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    HomePresenter homePresenter;
    RecyclerView recyclerView;
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public HomeFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static HomeFragment newInstance(int columnCount) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            //mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            mColumnCount = 1;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stock_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<StockQuote> stockQuotes = new ArrayList<>();
        recyclerView.setAdapter(new MyStockRecyclerViewAdapter(stockQuotes, this));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homePresenter = new HomePresenter(this);
        loadStockData();
    }

    public void loadStockData() {
        homePresenter.getStockData();
    }

    @Override
    public void loadStockQuotesSuccess(ArrayList<StockQuote> stockQuotes) {
        recyclerView.setAdapter(new MyStockRecyclerViewAdapter(stockQuotes, this));
    }

    @Override
    public void loadStockQuotesFailed() {
        Toast.makeText(getActivity(), "Server failed...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadStockDetailData(StockDetailResponse detailResponse) {
        
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void onItemClick(StockQuote stockQuote) {
        Intent intent = new Intent(getActivity(), StockDetailActivity.class);
        intent.putExtra("symbol", stockQuote.get1Symbol());
        getActivity().startActivity(intent);
    }

    public void loadStockData(CompanyModel companyModel) {
    }
}
