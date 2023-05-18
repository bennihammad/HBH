package com.hotel.hbh.helpers.reservation;

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
}
