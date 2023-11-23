package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import com.project.webshop.Models.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
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
     *  Visszaadja a kommenteket minden szükséges információval együtt egy List formájában
     * @param productID ehhez a termékhez kérjük le a kommenteket
     * @return kommentek
     */
    public List<Map<String,Object>> getComment(int productID) {
        List<Map<String,Object>> comments;
        String sqlCode = "SELECT * FROM comment INNER JOIN user ON comment.email = user.email WHERE comment.productID = ?;";
        comments = jdbcTemplate.queryForList(sqlCode, productID);

        /*CommentModel resultComment = CommentModel(((int) comment.get("productID"), (int) comment.get("rate"), comment.get("email").toString(),
                comment.get("comment").toString(), LocalDate.parse(comment.get("publishDate").toString()));*/
        return comments;
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
