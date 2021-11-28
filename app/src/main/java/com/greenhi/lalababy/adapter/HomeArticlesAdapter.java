package com.greenhi.lalababy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.item.ItemDataArticle;

import java.util.List;

public class HomeArticlesAdapter extends RecyclerView.Adapter<HomeArticlesAdapter.ViewHolder> {

    private List<ItemDataArticle> dataList;

    public HomeArticlesAdapter(List<ItemDataArticle> itemDataList) {
        dataList = itemDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_articles, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemDataArticle data = dataList.get(position);
        holder.title1.setText(data.getTitle1());
        holder.title2.setText(data.getTitle2());
        holder.icon.setImageResource(data.getIconID());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title1, title2;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title1 = itemView.findViewById(R.id.title1);
            title2 = itemView.findViewById(R.id.title2);
            icon = itemView.findViewById(R.id.imageView);
        }
    }

}
