package com.greenhi.lalababy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.item.ItemDataJournal;
import com.greenhi.lalababy.resultUnit.DiaryResult;

import java.util.List;

public class JournalRecyclerAdapter extends RecyclerView.Adapter<JournalRecyclerAdapter.ViewHolder> {

    List<DiaryResult.DataDTO> journals;

    public JournalRecyclerAdapter(List<DiaryResult.DataDTO> journals) {
        this.journals = journals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_journal, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(journals.get(position));
    }

    @Override
    public int getItemCount() {
        return journals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView day,year,age,title,content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            day=itemView.findViewById(R.id.tv_day);
            year=itemView.findViewById(R.id.tv_year);
            age=itemView.findViewById(R.id.tv_age);
            title=itemView.findViewById(R.id.tv_title);
            content=itemView.findViewById(R.id.tv_content);
        }

        public void bind(DiaryResult.DataDTO data){
            day.setText(data.getDay());
            year.setText(data.getYear());
            age.setText(data.getAge());
            title.setText(data.getTitle());
            content.setText(data.getContent());
        }

    }

}
