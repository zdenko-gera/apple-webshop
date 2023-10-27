package com.project.webshop.Models;

import java.util.List;
import java.util.Map;

public class CartModel {
    private int cartID, quantity;
    private String email;
    private List<ProductModel> itemsInCart;

    public CartModel(int cartID, int quantity, String email, List<ProductModel> itemsInCart) {
        this.cartID = cartID;
        this.quantity = quantity;
        this.email = email;
        this.itemsInCart = itemsInCart;
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
