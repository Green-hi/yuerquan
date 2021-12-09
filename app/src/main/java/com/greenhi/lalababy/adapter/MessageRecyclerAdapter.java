package com.greenhi.lalababy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.item.ItemDataMessage;

import java.util.List;

public class MessageRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerAdapter.ViewHolder> {

    private List<ItemDataMessage> msgList;

    public MessageRecyclerAdapter(List<ItemDataMessage> msgList) {
        this.msgList = msgList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_message, parent, false);
        MessageRecyclerAdapter.ViewHolder viewHolder = new MessageRecyclerAdapter.ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageRecyclerAdapter.ViewHolder holder, int position) {

        ItemDataMessage data = msgList.get(position);
        holder.icon.setImageResource(data.getIconImgID());
        holder.title.setText(data.getTitle());
        holder.message.setText(data.getMessage());
        holder.time.setText(data.getTime());
        holder.num.setText((""+data.getMsgNum()));   //注意！！！setText要传入String类型！！！
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView icon;
        TextView title,message,time,num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.icon = itemView.findViewById(R.id.icon);
            this.title = itemView.findViewById(R.id.tv_title);
            this.message = itemView.findViewById(R.id.tv_message);
            this.time = itemView.findViewById(R.id.tv_time);
            this.num = itemView.findViewById(R.id.tv_num);
        }
    }
}











