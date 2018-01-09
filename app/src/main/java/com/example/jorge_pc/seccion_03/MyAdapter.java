package com.example.jorge_pc.seccion_03;

import android.service.autofill.FillEventHistory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by JORGE-PC on 06/01/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Movie> movies;
    private int layout;
    private OnItemClickListener itemClickListener;


    public MyAdapter(List<Movie> movies,int layout, OnItemClickListener listener ) {
        this.movies=movies;
        this.layout=layout;
        this.itemClickListener= listener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //infla la vista
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(movies.get(position),itemClickListener);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView TextViewName;
        public ImageView imageViewPoster;
        public ViewHolder(View itemView) {
            super(itemView);
        }
        public void bind(final Movie movie,final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(movie,getAdapterPosition());
                }
            });

        }

    }



    public interface OnItemClickListener{
        void onItemClick(Movie movie,int position);
    }


}
