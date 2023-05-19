package com.hotel.hbh.helpers.reservation;

import com.hotel.hbh.data.Reservation;

import java.util.HashMap;
import java.util.Map;

public class ReserveChambreOptions {

    public final String nChambre;
    public final String chambre;
    public final String user;
    public final String userId;

    public ReserveChambreOptions(String nChambre, String chambre, String user, String userId) {
        this.nChambre = nChambre;
        this.chambre = chambre;
        this.user = user;
        this.userId = userId;
    }


    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();

        map.put(ReservationMapper.ReservationKeys.user.name(), user);
        map.put(ReservationMapper.ReservationKeys.userId.name(), userId);
        map.put(ReservationMapper.ReservationKeys.chambre.name(), chambre);
        map.put(ReservationMapper.ReservationKeys.chambreId.name(), nChambre);
        map.put(ReservationMapper.ReservationKeys.status.name(), Reservation.ReservationStatus.waiting.name());



        return map;
    }



}
