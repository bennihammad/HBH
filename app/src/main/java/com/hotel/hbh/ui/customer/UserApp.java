package com.hotel.hbh.ui.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hotel.hbh.R;

public class UserApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseApp.initializeApp(this);

        // code for using local emulator suite
        boolean isTestMode = false;

        if(isTestMode){
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            String emulatorHost = "192.168.1.5";
            db.useEmulator(emulatorHost,9000);

            FirebaseFirestore fr = FirebaseFirestore.getInstance();
            fr.useEmulator(emulatorHost,8080);
        }

    }
    public void openActivity(View view){
        Intent openActivity = new Intent(this, ChambersHome.class);
        startActivity(openActivity);
    }

}