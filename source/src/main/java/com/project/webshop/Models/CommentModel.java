package com.project.webshop.Models;

import java.time.LocalDateTime;
import java.util.Map;

public class CommentModel {
    private int commentID, productID, rate;
    private String email, comment;
    private LocalDateTime publishDate;

    public CommentModel(int commentID, int productID, int rate, String email, String comment, LocalDateTime publishDate) {
        this.commentID = commentID;
        this.productID = productID;
        this.rate = rate;
        this.email = email;
        this.comment = comment;
        this.publishDate = publishDate;
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
