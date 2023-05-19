package com.hotel.hbh.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hotel.hbh.R;
import com.hotel.hbh.data.Reservation;
import com.hotel.hbh.helpers.reservation.ReservationHelper;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class AdminApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_app);

        ArrayList<Reservation> reservationItems = new ArrayList<>();

        try {
            reservationItems = ReservationHelper.getInstance().getReservations().get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }


        // TODO populate your recylcerView


    }
}