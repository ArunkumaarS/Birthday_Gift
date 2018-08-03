package com.hundredbees.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NotificationActivity extends AppCompatActivity {
    List<Notification> notificationList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Notification notification = new Notification(getIntent().getStringExtra("title"),getIntent().getStringExtra("message"));
        notificationList.add(notification);
        //Full Screen view
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //Recycler View
        RecyclerView recyclerView = findViewById(R.id.notificationRecyclerView);
        List<Notification> list = new ArrayList<>();
       for(Notification notificationitr:notificationList){
           list.add(notification);
       }
        NotificationAdapter adapter = new NotificationAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
