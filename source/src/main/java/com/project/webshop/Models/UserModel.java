package com.project.webshop.Models;

import com.project.webshop.DAO.UserDAO;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



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
    public static String checkRegistrationData(String email, String firstname, String lastname, String password1, String password2) {
        String error = "?error=";

        if(!emailValidation(email)) {
            error += "emailFormat_";
        }

        if(!passwordValidation(password1) || !passwordValidation(password2)) {
            error += "passwordLength_";
        }

        if(!password1.equals(password2)) {
            error += "passwordNotEqual_";
        }

        if(firstname.trim().equals("") || lastname.trim().equals("")) {
            error += "nameError_";
        }

        if(error.charAt(error.length() - 1) == '_') {
            error = error.substring(0, error.length() - 1);
        }

        return error;
    }
    public static boolean emailValidation(String email) {
        String regex = "([a-zA-Z]([a-zA-Z0-9]*))@([a-zA-Z]{1,})[.]([a-zA-Z]{1,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
    public static boolean passwordValidation(String password) {
        return password.length() >= 8;
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
}
