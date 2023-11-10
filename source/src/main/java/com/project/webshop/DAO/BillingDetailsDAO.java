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

    /**
     * Regisztrációkor hozzáadja az alap adatokat a számlázási adatokhoz. Ezek a felhasználó oldalán nem jelennek meg
     * amíg nem változtatja meg, értelemszerűen egy -1-et nem írunk ki irányítószámnak, hanem nem írunk oda semmit.
     * @param email Az új felhasználó email címe
     * @return true ha sikeres, false különben
     */
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
    public void updateBillingDetails(String email, int postalcode, String city, String street, int housenumber) {}

    /**
     * Lekéri az adatbázisból a felhasználó számlázási adatait, és egy Map formájában visszaadja
     * @param email A felhasználó email címe
     * @return számlázási adatok Map formában
     */
    public Map getBillingDetails(String email) {
        String sqlCode = "SELECT * FROM billingdetails WHERE billingdetails.email = ?";
        return jdbcTemplate.queryForList(sqlCode, email).get(0);
    }
}
