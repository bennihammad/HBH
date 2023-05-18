package com.hotel.hbh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
    public void openActivity0(View view){
        Intent openActivity = new Intent(this,chambre_single.class);
        startActivity(openActivity);
    }
}