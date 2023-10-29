package com.project.webshop.Controllers;

import com.project.webshop.Models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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

    @PostMapping(value="registerUser")
    public String register(@RequestParam("email") String email,
                         @RequestParam("firstname") String firstname,
                         @RequestParam("lastname") String lastname,
                         @RequestParam("password1") String password1,
                         @RequestParam("password2") String password2) {
        System.out.println("halo");
        System.out.println(email + " " + firstname + " " + lastname + " " + password1 + " " + password2);
        return "redirect:/";
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
