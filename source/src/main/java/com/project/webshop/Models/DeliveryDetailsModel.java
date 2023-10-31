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
}
