package com.hotel.hbh.helpers.reservation;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReservationHelper {

    private static ReservationHelper instance;

    private final DatabaseReference db;

    private ReservationHelper() {
        this.db = FirebaseDatabase.getInstance().getReference("reservations");
    }

    public void reserveChambre(ReserveChambreOptions options){

        db.child(options.userId).setValue(
                options
        );

    }


    public static ReservationHelper getInstance(){
        if(instance != null){
            return instance;
        }
        instance = new ReservationHelper();

        return instance;
    }



}
