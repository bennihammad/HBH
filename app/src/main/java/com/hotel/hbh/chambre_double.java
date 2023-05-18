package com.hotel.hbh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class chambre_double extends AppCompatActivity {

    ImageView imageView;
    int[] images = {R.drawable.img_3,R.drawable.img_1,R.drawable.img, R.drawable.img_2};
    int currentIndex = 0;
    Handler handler = new Handler();
    Timer timer = new Timer();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chambre_double);

        imageView = findViewById(R.id.imageView5);

        // Schedule a timer task to change the image every 3 seconds
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // Change the image to the next one in the array
                        imageView.setImageResource(images[currentIndex]);
                        currentIndex = (currentIndex + 1) % images.length;
                    }
                });
            }
        }, 0, 3000); // Schedule the task to run every 3 seconds (3000 milliseconds)
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cancel the timer when the activity is destroyed to prevent memory leaks
        timer.cancel();
    }

    public void openActivity(View view){
        Intent openActivity = new Intent(this,reserver.class);
        startActivity(openActivity);
    }
}


