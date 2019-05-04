package com.example.group2.group2.view.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.group2.group2.R;
import com.example.group2.group2.model.CompanyModel;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link } and makes a call to the
 * specified {@link }.
 * TODO: Replace the implementation with code for your data type.
 */
public class CompanyListRecyclerViewAdapter extends RecyclerView.Adapter<CompanyListRecyclerViewAdapter.ViewHolder> {

    private final List<CompanyModel> companyModels;
    private final OnCompanyListClickListeners mListener;

    public CompanyListRecyclerViewAdapter(List<CompanyModel> companyModels, OnCompanyListClickListeners listener) {
        this.companyModels = companyModels;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_company, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.companyModel = companyModels.get(position);
        holder.tvCompanyName.setText(companyModels.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onItemClick(holder.companyModel);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return companyModels.size();
    }

    interface OnCompanyListClickListeners {
        void onItemClick(CompanyModel companyModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvCompanyName;
        public CompanyModel companyModel;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvCompanyName = (TextView) view.findViewById(R.id.tvCompanyName);
        }
    }
}
