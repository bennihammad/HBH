package com.hotel.hbh;

public class User {
    private String nom_et_prénom,email,numéro_de_téléphone,date_darrivéé,date_de_départ,chambre,nombre_de_chambre;

    public User() {
    }

    public User(String nom_et_prénom, String email, String numéro_de_téléphone, String date_darrivéé, String date_de_départ, String chambre, String nombre_de_chambre) {
        this.nom_et_prénom = nom_et_prénom;
        this.email = email;
        this.numéro_de_téléphone = numéro_de_téléphone;
        this.date_darrivéé = date_darrivéé;
        this.date_de_départ = date_de_départ;
        this.chambre = chambre;
        this.nombre_de_chambre = nombre_de_chambre;
    }

    public String getNom_et_prénom() {
        return nom_et_prénom;
    }

    public String getEmail() {
        return email;
    }

    public String getNuméro_de_téléphone() {
        return numéro_de_téléphone;
    }

    public String getDate_darrivéé() {
        return date_darrivéé;
    }

    public String getDate_de_départ() {
        return date_de_départ;
    }

    public String getChambre() {
        return chambre;
    }

    public String getNombre_de_chambre() {
        return nombre_de_chambre;
    }
}
