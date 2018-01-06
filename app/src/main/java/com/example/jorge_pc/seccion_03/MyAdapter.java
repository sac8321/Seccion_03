package com.example.jorge_pc.seccion_03;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by JORGE-PC on 06/01/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> names;
    private int layout;
    private OnItemClickListener listener;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;


        public ViewHolder(View itemView) {
            super(itemView);
            this.name=itemView.findViewById(R.id.textViewName);

        }
    }

    public interface OnItemClickListener{
        void onItemClick(String name,int position);
    }


}
