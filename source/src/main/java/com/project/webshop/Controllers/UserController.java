package com.project.webshop.Controllers;

import com.project.webshop.Models.*;

public class UserController {
    UserModel userModel;
    CartModel cartModel;
    BillingDetailsModel billingDetailsModel;
    DeliveryDetailsModel deliveryDetailsModel;
    CommentModel commentModel;
    ProductModel productModel;
    OrderModel orderModel;

    public UserController() {
    }

    public void register(String email, String firstname, String lastname, String password1, String password2) {

    }

    public void loginUser(String email, String password) {

    }

    public void updateCart(int itemID, int quantity) {

    }

    public void createOrder(int cartID) {

    }

    public void addComment(int productID, String comment, int rating) {

    }

    public void changePassword(String oldPassword, String newPassword1, String newPassword2) {

    }

    public void changeName(String firstname, String lastname) {

    }

    public void renderHomepage() {

    }

    public void renderLoginPage() {

    }

    public void renderAdminPage() {

    }

    public void renderProductPage() {

    }

    public void renderRegisterPage() {

    }

    public void renderWebshopPage() {

    }
}
