package com.project.webshop.Models;

import java.time.LocalDateTime;
import java.util.List;

public class OrderModel {
    private int orderID, price;
    private String email;
    private LocalDateTime orderDate;
    private List<ProductModel> orderedItems;

    public OrderModel(int orderID, int price, String email, LocalDateTime orderDate, List<ProductModel> orderedItems) {
        this.orderID = orderID;
        this.price = price;
        this.email = email;
        this.orderDate = orderDate;
        this.orderedItems = orderedItems;
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
