package com.project.webshop.Models;

import java.util.Map;

public class BillingDetailsModel {
    private String email, city, street;
    private int postalcode, housenumber;

    public BillingDetailsModel(String email, int postalcode, String city, String street, int housenumber) {
        this.email = email;
        this.city = city;
        this.street = street;
        this.postalcode = postalcode;
        this.housenumber = housenumber;
    }

    /**
     * @param email A felhasználó email címe egyértelműen azonosítja a sort az adatbázisban (kulcs)
     * @param postalcode A leendő számla irányítószáma
     * @param city A leendő számla városa
     * @param street A leendő számla utcája
     * @param housenumber A leendő számla házszáma
     * Ebben a függvényben van megvalósítva a számlázási adatok módosítását végző SQL kód
     */
    public void updateBillingDetails(String email, int postalcode, String city, String street, int housenumber) {

    }

    /**
     * Lekéri az adatbázisból a felhasználó számlázási adatait, és egy Map formájában visszaadja
     * @return számlázási adatok Map formában
     */
    public Map getBillingDetails() {
        return null;
    }
}
