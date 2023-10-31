package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import com.project.webshop.Models.CartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.core.JdbcTemplate;

@Table(name="orders")
public class OrderDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;
    public OrderDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
    }

    /**
     * Egy új rendelést ad hozzá az adatbázishoz
     * @param email A felhasználó email címe
     * @param cart A felhasználó kosara
     * @return
     */
    public boolean placeOrder(String email, CartModel cart) {
        return false;
    }

    /**
     * Töröl egy meglévő rendelést, ha rövid időn belül törli
     * @param email A felhasználó email címe
     * @param orderID A rendelés azonosítója
     * @return
     */
    public boolean deleteOrder(String email, int orderID) {
        return false;
    }
}
