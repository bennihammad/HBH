package com.hotel.hbh.ui.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hotel.hbh.R;

public class UserApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void openActivity(View view){
        Intent openActivity = new Intent(this, ChambersHome.class);
        startActivity(openActivity);
    }

}