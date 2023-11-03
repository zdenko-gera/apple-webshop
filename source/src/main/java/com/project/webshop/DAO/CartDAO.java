package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import com.project.webshop.Models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class CartDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;
    public CartDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
    }


    public boolean insertCart(String email) {
        String sqlCode = "INSERT INTO cart (email) VALUES (?)";
        return jdbcTemplate.update(sqlCode, email) == 1;
    }
    /**
     * Ebben a függvényben van megvalósítva a kosárhoz hozzáadás
     * @param email A felhasználó email címe
     * @param product A termék amit hozzá akarunk adni
     * @param quantity darabszám
     */
    public boolean addToCart(String email, ProductModel product, int quantity) {
        return false;
    }


    /**
     * Ebben a függvényben van megvalósítva a kosárból törlés
     * @param email A felhasználó email címe
     * @param product A termék amit hozzá akarunk adni
     * @param quantity darabszám
     */
    public boolean removeFromCart(String email, ProductModel product, int quantity) {
        return false;
    }

    /**
     * Ebben a függvényben van megvalósítva a kosárból törlés
     * @return A kosár tartalma Map formában
     */
    public Map getCart() {
        return null;
    }
}
