package com.project.webshop.Models;

import com.project.webshop.DAO.CartDAO;

import java.util.List;

public class CartModel {
    private int cartID, quantity;
    private String email;
    private List<ProductModel> itemsInCart;

    CartDAO cartDAO;
    public CartModel(int cartID, int quantity, String email, List<ProductModel> itemsInCart) {
        this.cartID = cartID;
        this.quantity = quantity;
        this.email = email;
        this.itemsInCart = itemsInCart;
        cartDAO = new CartDAO();
    }

    public CartDAO getCartDAO() {
        return cartDAO;
    }
}
