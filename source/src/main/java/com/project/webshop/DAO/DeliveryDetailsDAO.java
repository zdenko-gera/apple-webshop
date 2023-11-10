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
     * Regisztrációkor hozzáadja az alap adatokat a szállítási adatokhoz. Ezek a felhasználó oldalán nem jelennek meg,
     * amíg nem változtatja meg, értelemszerűen egy -1-et nem írunk ki irányítószámnak, hanem nem írunk oda semmit.
     * @param email Az új felhasználó email címe
     * @return true ha sikeres, false különben
     */
    public boolean insertDeliveryDetails(String email) {
        String sqlCode = "INSERT INTO deliverydetails (email, postalcode, city, street, housenumber) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sqlCode, email, -1, "", "", -1) == 1;
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
     * @param email A felhasználó email címe
     * @return számlázási adatok Map formában
     */
    public Map getDeliveryDetails(String email) {
        String sqlCode = "SELECT * FROM deliverydetails WHERE deliverydetails.email = ?";
        return jdbcTemplate.queryForList(sqlCode, email).get(0);
    }
}
