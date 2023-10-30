package com.project.webshop.Controllers;

import com.project.webshop.Models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String error = "?error=";

        if(!emailValidation(email)) {
            error += "emailFormat_";
        }

        if(!passwordValidation(password1) || !passwordValidation(password2)) {
            error += "passwordLength_";
        }

        if(password1 != password2) {
            error += "passwordNotEqual_";
        }

        if(firstname.trim() == "" || lastname.trim() == "") {
            error += "nameError_";
        }

        if(error.charAt(error.length() - 1) == '_') {
            error = error.substring(0, error.length() - 1);
        }
        System.out.println("halo");
        System.out.println(email + " " + firstname + " " + lastname + " " + password1 + " " + password2);
        if(error == "?error=") {

            return "redirect:/Signup?reg=success";
        }
        return "redirect:/Signup" + error;
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


    /**
     * Leellenőrzi az email cím formátumát, hogy megfelelő-e. Az email cím formátuma akkor megfelelő, ha:
     * <li>a @ karakter előtti rész csak kisbetűt, nagybetűt, vagy számot tartalmaz, de nem kezdődhet számmal. <br>
     * illetve legalább egy betű van benne, felső korlát nincs megadva. </li>
     * <li>van benne @ karakter</li>
     * <li>a @ karakter után nem lehet '.', '_' vagy '-' karakter.</li>
     * <li>a @ karakter után, de a . előtt van legalább 1 karakter, ami kisbetű, vagy nagybetű, szám nem lehet</li>
     * <li>ezután van 1 darab '.'</li>
     * <li>a pont után van legalább egy darab karakter, de nincs felső határa</li>
     * <li>nem végződik '.'-ra vagy '_'-ra vagy '-'-ra</li>
     *
     * @param email Az email cím, amiről ellenőrizni kell, hogy megfelelő-e a formátuma
     * @return true, ha jó a formátum, false különben
     */
    public boolean emailValidation(String email) {
        String regex = "([a-zA-Z]([a-zA-Z0-9]*))@([a-zA-Z]{1,})[.]([a-zA-Z]{1,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public boolean passwordValidation(String password) {
        return password.length() >= 8;
    }
}
