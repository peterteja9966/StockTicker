package com.example.group2.group2.view.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.group2.group2.R;
import com.example.group2.group2.model.response.StockQuote;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link } and makes a call to the
 * specified {@link }.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyStockRecyclerViewAdapter extends RecyclerView.Adapter<MyStockRecyclerViewAdapter.ViewHolder> {

    private final List<StockQuote> mStockQuotes;
    private final OnListClickListeners mListener;

    public MyStockRecyclerViewAdapter(List<StockQuote> stockQuotes, OnListClickListeners listener) {
        mStockQuotes = stockQuotes;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_stock, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.stockQuote = mStockQuotes.get(position);
        holder.tvCompanyName.setText(mStockQuotes.get(position).get1Symbol());
        holder.tvCompanyStock.setText(mStockQuotes.get(position).get2Price());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onItemClick(holder.stockQuote);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStockQuotes.size();
    }

    interface OnListClickListeners {
        void onItemClick(StockQuote stockQuote);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvCompanyName;
        public final TextView tvCompanyStock;
        public StockQuote stockQuote;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvCompanyName = (TextView) view.findViewById(R.id.tvCompanyName);
            tvCompanyStock = (TextView) view.findViewById(R.id.tvCompanyStock);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvCompanyStock.getText() + "'";
        }
    }
}
