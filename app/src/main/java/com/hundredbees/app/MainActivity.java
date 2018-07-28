package com.hundredbees.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Full Screen view
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //Recycler View
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        List<item> list = new ArrayList<>();
        list.add(new item(R.drawable.splashscreenevening,R.drawable.bee,"Evening"));
        list.add(new item(R.drawable.splashscreenmorning,R.drawable.hundred,"Morning"));
        list.add(new item(R.drawable.splashscreennight,R.drawable.splashscreennight,"Night"));
        list.add(new item(R.drawable.splashscreenevening,R.drawable.splashscreenevening,"Evening"));
        list.add(new item(R.drawable.splashscreenmorning,R.drawable.splashscreenmorning,"Morning"));
        list.add(new item(R.drawable.splashscreennight,R.drawable.splashscreennight,"Night"));

        Adapter adapter = new Adapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Notification buttuon
        ImageButton notificationButtion = findViewById(R.id.notificationbutton);
        notificationButtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(i);
            }
        });


    }

     void buttonClick(View view){
         TextView textView = findViewById(R.id.profilename);
         Toast.makeText(MainActivity.this,textView.getText(),Toast.LENGTH_LONG).show();
     }
}
