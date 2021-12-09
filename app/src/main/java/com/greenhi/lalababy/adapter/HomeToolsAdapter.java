package com.greenhi.lalababy.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.activity.Home1Activity;
import com.greenhi.lalababy.activity.Home2Activity;
import com.greenhi.lalababy.activity.Home3Activity;
import com.greenhi.lalababy.activity.Home4Activity;
import com.greenhi.lalababy.item.ItemDataTools;

import java.util.List;

public class HomeToolsAdapter extends RecyclerView.Adapter<HomeToolsAdapter.ViewHolder> {

    List<ItemDataTools> toolList;

    ViewGroup root;

    public HomeToolsAdapter(List<ItemDataTools> toolList) {
        this.toolList = toolList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        root = parent;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_apptools,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ItemDataTools data = toolList.get(position);
        holder.icon.setImageResource(data.getIconID());
        holder.title.setText(data.getTitle());
        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context mContext = view.getContext();
                //Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        Intent intent1 = new Intent(mContext, Home1Activity.class);
                        mContext.startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2 = new Intent(mContext, Home2Activity.class);
                        mContext.startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(mContext, Home3Activity.class);
                        mContext.startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(mContext, Home4Activity.class);
                        mContext.startActivity(intent4);
                        break;
                    default:
                        break;
                }
            }
        });
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
