package com.greenhi.lalababy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.item.ItemDataTools;

import java.util.List;

public class HomeToolsAdapter extends RecyclerView.Adapter<HomeToolsAdapter.ViewHolder> {

    List<ItemDataTools> toolList;

    public HomeToolsAdapter(List<ItemDataTools> toolList) {
        this.toolList = toolList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_apptools,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemDataTools data = toolList.get(position);
        holder.icon.setImageResource(data.getIconID());
        holder.title.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        return toolList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView icon;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.icon = itemView.findViewById(R.id.iv_icon);
            this.title = itemView.findViewById(R.id.tv_title);
        }
    }

}
