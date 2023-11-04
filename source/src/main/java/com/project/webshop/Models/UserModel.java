package com.project.webshop.Models;

import com.project.webshop.DAO.UserDAO;

import java.time.LocalDate;



public class UserModel {
    private CartModel cartModel;
    private BillingDetailsModel billingDetailsModel;
    private DeliveryDetailsModel deliveryDetailsModel;
    private CommentModel commentModel;
    private OrderModel orderModel;

    private String email, password, firstname, lastname, role;
    private LocalDate registrationDate;

    UserDAO userDAO;

    public UserModel(String email, String password, String firstname, String lastname, String role, LocalDate registrationDate) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.registrationDate = registrationDate;

        cartModel = new CartModel(-1, -1, email, null);
        billingDetailsModel = new BillingDetailsModel(email, -1, null, null, -1);
        deliveryDetailsModel = new DeliveryDetailsModel(email, -1, null, null, -1);
        commentModel = new CommentModel(-1, -1, -1, email, null, null);
        orderModel = new OrderModel(-1, -1, email, null, null);
        userDAO = new UserDAO();
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public UserDAO getUserDAO() {
        return userDAO;
    }
    public CartModel getCartModel() {
        return cartModel;
    }
    public BillingDetailsModel getBillingDetailsModel() {
        return billingDetailsModel;
    }
    public DeliveryDetailsModel getDeliveryDetailsModel() {
        return deliveryDetailsModel;
    }
}
