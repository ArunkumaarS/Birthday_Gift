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

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    Context mcoContext;
    List<item> mData;

    public Adapter(Context mcoContext, List<item> mData) {
        this.mcoContext = mcoContext;
        this.mData = mData;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(mcoContext);
        View view = inflater.inflate(R.layout.card_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        holder.background_img.setImageResource(mData.get(position).getBackground());
        holder.profile_photo.setImageResource(mData.get(position).getProfilepic());
        holder.name.setText(mData.get(position).getProfileName());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mcoContext,SecondActivity.class);
                mcoContext.startActivity(i);

                Toast.makeText(mcoContext,mData.get(position).getProfileName(),Toast.LENGTH_LONG).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView profile_photo,background_img;
        TextView name;
        Button button;

        public myViewHolder(View itemView) {
            super(itemView);
            profile_photo = itemView.findViewById(R.id.profile_pic);
            background_img = itemView.findViewById(R.id.imageprofile);
            name = itemView.findViewById(R.id.profilename);
            button = itemView.findViewById(R.id.button_profile1);
        }
    }
}
