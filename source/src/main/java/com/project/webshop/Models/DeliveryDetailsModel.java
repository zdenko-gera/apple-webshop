package com.project.webshop.Models;

import java.util.Map;

public class DeliveryDetailsModel {
    private String email, city, street;
    private int postalcode, housenumber;

    public DeliveryDetailsModel(String email, int postalcode, String city, String street, int housenumber) {
        this.email = email;
        this.city = city;
        this.street = street;
        this.postalcode = postalcode;
        this.housenumber = housenumber;
    }

    /**
     * Ebben a függvényben van megvalósítva a szállítási adatok módosítását végző SQL kód
     * @param email A felhasználó email címe egyértelműen azonosítja a sort az adatbázisban (kulcs)
     * @param postalcode A szállítási cím irányítószáma
     * @param city A szállítási cím városa
     * @param street A szállítási cím utcája
     * @param housenumber A szállítási cím házszáma
     */
    public void updateDeliveryDetails(String email, int postalcode, String city, String street, int housenumber) {

    }

    /**
     * Lekéri az adatbázisból a felhasználó számlázási adatait, és egy Map formájában visszaadja
     * @return számlázási adatok Map formában
     */
    public Map getDeliveryDetails() {
        return null;
    }
}
