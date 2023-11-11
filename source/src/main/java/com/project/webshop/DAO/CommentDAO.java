package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class CommentDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;
    public CommentDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
        jdbcTemplate.setQueryTimeout(5);
    }


    /**
     * Ez a függvény valósítja meg egy új komment létrehozását az adatbázisbans
     * @param email A felhasználó email címe
     * @param rate A termékre adott értékelés
     * @param comment A termékre adott értékelés szövege
     */
    public void createComment(String email, int rate, String comment) {

    }

    /**
     *  Visszaadja a kommentet minden szükséges információval együtt egy Map formájában
     * @return
     */
    public Map getComment() {
        return null;
    }

    /**
     * Ez a függvény valósítja meg egy létező komment módosítását az adatbázisbans
     * @param email A felhasználó email címe
     * @param commentID Az értékelés azonosítója
     */
    public void updateComment(String email, int commentID) {

    }

    /**
     * Ez a függvény valósítja meg egy létező komment törlését az adatbázisbans
     * @param email A felhasználó email címe
     * @param commentID A termékre adott értékelés szövege
     * @return True ha sikeres a törlés, false különben
     */
    public Boolean deleteComment(String email, int commentID) {
        return false;
    }
}
