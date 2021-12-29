package com.example.nav_drawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.RecyclerViewHolder> {

ArrayList<String> arrayList = new ArrayList<>();
public RecyclerAdapter(ArrayList<String> arrayList){
  this.arrayList=arrayList;
}
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecyclerViewHolder viewHolder= new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
holder.textView.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static  class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private final Object TextView;
        TextView textView;
        public RecyclerViewHolder(View view){

            super(view);
            TextView = (TextView)view.findViewById(R.id.txt_item);
        }
    }
}

