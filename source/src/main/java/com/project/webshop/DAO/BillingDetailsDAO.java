package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class BillingDetailsDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;
    public BillingDetailsDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
    }


    public boolean insertBillingDetails(String email) {
        String sqlCode = "INSERT INTO billingdetails (email, postalcode, city, street, housenumber) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sqlCode, email, -1, "", "", -1) == 1;
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
