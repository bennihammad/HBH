package com.hotel.hbh.helpers.reservation;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hotel.hbh.data.Reservation;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ReservationHelper {

    private static ReservationHelper instance;

    private final DatabaseReference db;

    private ReservationHelper() {
        this.db = FirebaseDatabase.getInstance().getReference("reservations");
    }

    public void reserveChambre(ReserveChambreOptions options) {


        db.child(options.userId).setValue(
                options.toMap()
        );


    }

    public Future<ArrayList<Reservation>> getReservations() {
        CompletableFuture<ArrayList<Reservation>> future = new CompletableFuture<>();

        db.get().addOnCompleteListener(r -> {
            ArrayList<Reservation> reservations = new ArrayList<>();

            Map<String, Map<String, Object>> data = (Map<String, Map<String, Object>>) r.getResult().getValue();
            if (data != null) {
                reservations = ReservationMapper.snapshotToReservationArray(data);
            }

            future.complete(reservations);
        });

        return future;
    }

    public void validateReservation(String reservationId) {

        db.child(reservationId).child(
                ReservationMapper.ReservationKeys.status.name()
        ).setValue(
                Reservation.ReservationStatus.reserved.name()
        );
    }


    public static ReservationHelper getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new ReservationHelper();

        return instance;
    }


}
