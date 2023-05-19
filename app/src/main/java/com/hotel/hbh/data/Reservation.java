package com.hotel.hbh.data;

public class Reservation {
    public final String user;
    public final String userId;
    public final String chambre;
    public final String chambreId;
    public final ReservationStatus status;

    public Reservation(String user, String userId, String chambre, String chambreId, ReservationStatus status) {
        this.user = user;
        this.userId = userId;
        this.chambre = chambre;
        this.chambreId = chambreId;
        this.status = status;
    }


    public enum ReservationStatus{
        reserved,
        waiting
    }
}
