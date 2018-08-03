package com.hundredbees.app;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.myViewHolder> {

    Context mcoContext;
    List<Notification> mData;

    public NotificationAdapter(Context mcoContext, List<Notification> mData) {
        this.mcoContext = mcoContext;
        this.mData = mData;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(mcoContext);
        View view = inflater.inflate(R.layout.notification_list,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        holder.title.setText(mData.get(position).getTitle());
        holder.message.setText(mData.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView message;

        public myViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.NotificationTitle);
            message = itemView.findViewById(R.id.NotificationMessage);
        }
    }
}
