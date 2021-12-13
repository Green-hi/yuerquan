package com.greenhi.lalababy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.item.ItemDataProfile;

import java.util.List;

public class ProfileRecyclerAdapter extends RecyclerView.Adapter<ProfileRecyclerAdapter.ViewHolder> {  //此处记得传入泛型
                                                                                              // 默认是RecyclerView.ViewHolder
    List<ItemDataProfile> toolList;
    OnItemClickListener mListener;

    public ProfileRecyclerAdapter(List<ItemDataProfile> toolList,OnItemClickListener listener) {
        this.toolList = toolList;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ProfileRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_profile, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileRecyclerAdapter.ViewHolder holder, int position) {

        holder.position = position;
        holder.icon.setImageResource(toolList.get(position).getIconImgID());
        holder.title1.setText(toolList.get(position).getTitle1());
        holder.title2.setText(toolList.get(position).getTitle2());
        switch (toolList.get(position).getViewVisible()){
            case 0:
            holder.view.setVisibility(View.GONE);
                break;
            case 1:
                holder.view.setVisibility(View.VISIBLE);
                break;
            case 2:
                holder.view.setVisibility(View.INVISIBLE);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return toolList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView icon;
        TextView title1,title2;
        View view;

        int position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.icon = itemView.findViewById(R.id.icon);
            this.title1 = itemView.findViewById(R.id.tv_title1);
            this.title2 = itemView.findViewById(R.id.tv_title2);
            this.view = itemView.findViewById(R.id.view3);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(position);
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

}
