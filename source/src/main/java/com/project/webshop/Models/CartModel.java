package com.project.webshop.Models;

import com.project.webshop.DAO.CartDAO;

import java.util.ArrayList;
import java.util.List;

public class CartModel {
    private int cartID;
    private String email;
    private List<Integer> itemsInCart;
    private List<Integer> quantityInCart;

    CartDAO cartDAO;
    public CartModel(String email, List<Integer> itemsInCart, List<Integer> quantityInCart) {
        this.quantityInCart = quantityInCart;
        this.email = email;
        this.itemsInCart = itemsInCart;

        cartDAO = new CartDAO();
        this.cartID = cartDAO.getUserCartID(email);
    }

    public CartDAO getCartDAO() {
        return cartDAO;
    }

    public int getCartID() {
        return cartID;
    }

    public String getEmail() {
        return email;
    }

    public boolean hasItem(int productID) {
        for(int i = 0; i < itemsInCart.size(); i++) {
            if(itemsInCart.get(i) == productID) {
                return true;
            };
        }
        return false;
    }

    public void addItemToCart(int productID, int quantity) {
        itemsInCart.add(productID);
        quantityInCart.add(quantity);
    }

    public void removeItemFromCart(int productID) {
        int index = -1;
        for(int i = 0; i < itemsInCart.size(); i++) {
            if(itemsInCart.get(i) == productID) {
                index = i;
                break;
            }
        }

        if(index != -1) {
            itemsInCart.remove(index);
            quantityInCart.remove(index);
        }
    }

    public void updateQuantityInCart(int productID, int newQuantity) {
        if (hasItem(productID)) {
            int index = itemsInCart.indexOf(productID);
            quantityInCart.set(index, newQuantity);
            cartDAO.updateQuantityByID(cartID, Integer.toString(productID), Integer.toString(newQuantity));
        }
    }

    @Override
    public String toString() {
        return "CartModel{" +
                "cartID=" + cartID +
                ", email='" + email + '\'' +
                ", itemsInCart=" + itemsInCart +
                ", quantityInCart=" + quantityInCart +
                '}';
    }

    public void clearCart() {
        itemsInCart = new ArrayList<Integer>();
        quantityInCart = new ArrayList<Integer>();
    }
}
