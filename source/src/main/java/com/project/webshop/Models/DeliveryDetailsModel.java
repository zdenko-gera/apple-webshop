package com.project.webshop.Models;

import com.project.webshop.DAO.DeliveryDetailsDAO;

public class DeliveryDetailsModel {
    private String email, city, street;
    private int postalcode, housenumber;

    DeliveryDetailsDAO deliveryDetailsDAO;
    public DeliveryDetailsModel(String email, int postalcode, String city, String street, int housenumber) {
        this.email = email;
        this.city = city;
        this.street = street;
        this.postalcode = postalcode;
        this.housenumber = housenumber;
        deliveryDetailsDAO = new DeliveryDetailsDAO();
    }

    public DeliveryDetailsDAO getDeliveryDetailsDAO() {
        return deliveryDetailsDAO;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    @Override
    public String toString() {
        return "DeliveryDetailsModel{" +
                "email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalcode=" + postalcode +
                ", housenumber=" + housenumber +
                '}';
    }
}
