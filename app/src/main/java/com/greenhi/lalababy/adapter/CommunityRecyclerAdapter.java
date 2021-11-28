package com.greenhi.lalababy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.item.ItemDataCommunity;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CommunityRecyclerAdapter extends RecyclerView.Adapter<CommunityRecyclerAdapter.ViewHolder> {

    private List<ItemDataCommunity> comList;
    //private LayoutInflater mInflater;
    //private int mShowStyle;

    public CommunityRecyclerAdapter(List<ItemDataCommunity> comList) {
        this.comList = comList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_community, parent, false);
        CommunityRecyclerAdapter.ViewHolder viewHolder = new CommunityRecyclerAdapter.ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityRecyclerAdapter.ViewHolder holder, int position) {

        holder.bind(comList.get(position));

//        ItemDataCommunity data = comList.get(position);
//        holder.head.setImageResource(data.getHeadID());
//        holder.name.setText(data.getName());   //注意！！！setText要传入String类型！！！
//        holder.status.setText(data.getStatus());
//        holder.time.setText(data.getTime());
//        if(data.getAddress()!=""){
//            holder.address.setText((data.getAddress()));
//        }else {
//            holder.address.setVisibility(View.GONE);
//        }
//        holder.comment.setText(data.getComment());
//        holder.like.setText(data.getLike());
//        holder.tvExpand.setText(data.getComText());
//        if(data.getImgList()!=null){
//            holder.nineGrid.setAdapter(holder.mAdapter);
//            holder.nineGrid.setImagesData(data.getImgList());
//        }
    }

    @Override
    public int getItemCount() {
        return comList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView head;
        TextView name, status, time, address, comment, like;
        ExpandableTextView tvExpand;
        NineGridImageView nineGrid;

        private NineGridImageViewAdapter<Integer> mAdapter = new NineGridImageViewAdapter<Integer>() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, Integer url) {
                Picasso.with(context).load(url).placeholder(R.drawable.com_img1).into(imageView);
            }

            @Override
            protected ImageView generateImageView(Context context) {
                return super.generateImageView(context);
            }

            @Override
            protected void onItemImageClick(Context context, ImageView imageView, int index, List<Integer> list) {
                super.onItemImageClick(context, imageView, index, list);
                //Toast.makeText(context, "image position is " + index, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected boolean onItemImageLongClick(Context context, ImageView imageView, int index, List<Integer> list) {
                super.onItemImageLongClick(context, imageView, index, list);
                //Toast.makeText(context, "image long click position is " + index, Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.head = itemView.findViewById(R.id.iv_head);
            this.name = itemView.findViewById(R.id.tv_name);
            this.status = itemView.findViewById(R.id.tv_status);
            this.time = itemView.findViewById(R.id.tv_time);
            this.address = itemView.findViewById(R.id.tv_address);
            this.comment = itemView.findViewById(R.id.tv_comment);
            this.like = itemView.findViewById(R.id.tv_liked);
            this.tvExpand = itemView.findViewById(R.id.tv_expand);
            this.nineGrid = itemView.findViewById(R.id.ninegrid);
            nineGrid.setAdapter(mAdapter);
        }

        public void bind(ItemDataCommunity data) {
            head.setImageResource(data.getHeadID());
            name.setText(data.getName());   //注意！！！setText要传入String类型！！！
            status.setText(data.getStatus());
            time.setText(data.getTime());
            if (data.getAddress() != "") {
                address.setText((data.getAddress()));
            } else {
                address.setVisibility(View.GONE);
            }
            comment.setText(data.getComment());
            like.setText(data.getLike());
            tvExpand.setText(data.getComText());
            if (data.getImgList() != null) {
                nineGrid.setImagesData(data.getImgList());
                nineGrid.setVisibility(View.VISIBLE);
            }
//            Log.d("jaeger", "九宫格高度: " + nineGrid.getMeasuredHeight());
//            Log.d("jaeger", "item 高度: " + itemView.getMeasuredHeight());
        }
    }
}