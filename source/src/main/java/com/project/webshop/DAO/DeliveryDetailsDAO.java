package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class DeliveryDetailsDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;
    public DeliveryDetailsDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
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
