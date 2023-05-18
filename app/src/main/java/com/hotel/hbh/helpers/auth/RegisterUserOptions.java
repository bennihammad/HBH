package com.hotel.hbh.helpers.auth;

public class RegisterUserOptions {
    public final String nom;
    public final String email;
    public final String phone;
    public final String chambre;
    public final String nChambre;
    public final String dateArrive;
    public final String dateDepart;

    public RegisterUserOptions(String nom, String email, String phone, String chambre, String nChambre, String dateArrive, String dateDepart) {
        this.nom = nom;
        this.email = email;
        this.phone = phone;
        this.chambre = chambre;
        this.nChambre = nChambre;
        this.dateArrive = dateArrive;
        this.dateDepart = dateDepart;
    }
}
