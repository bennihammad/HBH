package com.hotel.hbh.helpers.reservation;

import com.google.firebase.database.DataSnapshot;
import com.hotel.hbh.data.Reservation;

import java.util.ArrayList;
import java.util.Map;

public class ReservationMapper {
    public static Reservation snapshotToReservation(Map<String, Object> snapshot) {


        String rawStatus =  (String) snapshot.get(ReservationKeys.status.name());

        return new Reservation(
                (String) snapshot.get(ReservationKeys.user.name()),
                (String)  snapshot.get(ReservationKeys.userId.name()),
                (String) snapshot.get(ReservationKeys.chambre.name()),
                (String) snapshot.get(ReservationKeys.chambreId.name()),
                Reservation.ReservationStatus.valueOf(rawStatus)

        );
    }


    public static ArrayList<Reservation> snapshotToReservationArray(Map<String, Map<String, Object>> snapshot) {
        ArrayList<Reservation> reservations = new ArrayList<>();

        snapshot.forEach((key, data) -> {
            reservations.add(snapshotToReservation(data));

        });

        return reservations;


    }


    public enum ReservationKeys {
        user,
        userId,
        chambre,
        chambreId,
        status
    }
}
