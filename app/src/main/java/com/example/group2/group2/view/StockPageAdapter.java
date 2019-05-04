package com.example.group2.group2.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class StockPageAdapter extends RecyclerView.Adapter<StockPageAdapter.StockPageViewHolder> {

    //private List<Result> resultList = new ArrayList<>();

    public StockPageAdapter() {

    }

    @NonNull
    @Override
    public StockPageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_random_user, viewGroup, false);
        //return new StockPageViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StockPageViewHolder holder, int position) {
        //Result result = resultList.get(position);
        //holder.textView.setText(String.format("%s %s", result.getName().getFirst(),
        //result.getName().getLast()));
    }

    @Override
    public int getItemCount() {
        //return resultList.size();
        return 0;
    }

//    public void setItems(List<> results) {
//        //resultList = results;
//        notifyDataSetChanged();
//    }

    public class StockPageViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;

        public StockPageViewHolder(View itemView) {
            super(itemView);
            //textView = itemView.findViewById(R.id.name);

        }
    }
}