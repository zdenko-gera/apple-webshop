package com.project.webshop.Models;

import com.project.webshop.DAO.BillingDetailsDAO;

public class BillingDetailsModel {
    private String email, city, street;
    private int postalcode, housenumber;

    BillingDetailsDAO billingDetailsDAO;
    public BillingDetailsModel(String email, int postalcode, String city, String street, int housenumber) {
        this.email = email;
        this.city = city;
        this.street = street;
        this.postalcode = postalcode;
        this.housenumber = housenumber;
        billingDetailsDAO = new BillingDetailsDAO();
    }

    public BillingDetailsDAO getBillingDetailsDAO() {
        return billingDetailsDAO;
    }
}
