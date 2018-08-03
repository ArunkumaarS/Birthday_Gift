package com.hundredbees.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name = getIntent().getStringExtra("Name");
        if(name.equalsIgnoreCase("Night")){
            
        }
        setContentView(R.layout.activity_second);
    }
}
