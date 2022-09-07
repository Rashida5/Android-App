package com.example.aboutme;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter  extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Activity activity;
    ArrayList<Object> obj;

    public Adapter(Activity activity, ArrayList<Object> obj) {
        this.activity = activity;
        this.obj = obj;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflator
        LayoutInflater inflater=activity.getLayoutInflater();
       View v= inflater.inflate(R.layout.list_item,parent,false);
        MyViewHolder holder= new MyViewHolder(v);
       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         holder.textView.setText(obj.get(position).text);
         holder.Img.setImageResource(obj.get(position).Img);
    }

    @Override
    public int getItemCount() {
        return obj.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView Img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv);
            Img=itemView.findViewById(R.id.iv);
        }
    }
}
