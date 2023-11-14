package com.project.webshop.Models;

import com.project.webshop.DAO.BillingDetailsDAO;
import com.project.webshop.DAO.CartDAO;
import com.project.webshop.DAO.DeliveryDetailsDAO;
import com.project.webshop.DAO.UserDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    /**
     * Ez egy konstruktor, de nagyon fontos, mivel bejelentkezéskor ez hozza létre a UserModelt ami belekerül a sessionbe, amivel
     * később dolgozunk. <br> <br>
     *
     * Adatbázisból betölti a kosarat, számlázási és szállítási adatokat is. Ezt a DAO-n keresztül teszi meg, és a meglévő
     * Modelleket a settereik segítségével állítja be. A kosár egy Lista amiben Map-ek vannak, amiben a kulcs a tábla egy
     * attribútuma, az értéke az attribútum értéke.
     * @param email A felhasználó email címe
     * @param password A felhasználó jelszava
     * @param firstname A felhasználó keresztneve
     * @param lastname A felhasználó vezetékneve
     * @param role A felhasználó szerepe a weboldalon
     * @param registrationDate A felhasználó regisztrációjának dátuma
     */
    public UserModel(String email, String password, String firstname, String lastname, String role, LocalDate registrationDate) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.registrationDate = registrationDate;

        cartModel = new CartModel(email, new ArrayList<>(), new ArrayList<>());
        billingDetailsModel = new BillingDetailsModel(email, -1, null, null, -1);
        deliveryDetailsModel = new DeliveryDetailsModel(email, -1, null, null, -1);
        commentModel = new CommentModel(-1, -1, -1, email, null, null);
        orderModel = new OrderModel(-1, -1, email, null, null);
        userDAO = new UserDAO();

        List<Map<String, Object>> cart = cartModel.getCartDAO().getCart(email);
        for (Map<String, Object> item : cart) {
            System.out.println("HalikaMalika");
            cartModel.addItemToCart((Integer) item.get("productID"), (Integer) item.get("quantity"));
        }

        try {
            Map billingdetails = billingDetailsModel.billingDetailsDAO.getBillingDetails(email);
            billingDetailsModel.setPostalcode((Integer) billingdetails.get("postalcode"));
            billingDetailsModel.setCity((String) billingdetails.get("city"));
            billingDetailsModel.setStreet((String) billingdetails.get("street"));
            billingDetailsModel.setHousenumber((Integer) billingdetails.get("housenumber"));
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            Map deliverydetails = deliveryDetailsModel.getDeliveryDetailsDAO().getDeliveryDetails(email);
            deliveryDetailsModel.setPostalcode((Integer) deliverydetails.get("postalcode"));
            deliveryDetailsModel.setCity((String) deliverydetails.get("city"));
            deliveryDetailsModel.setStreet((String) deliverydetails.get("street"));
            deliveryDetailsModel.setHousenumber((Integer) deliverydetails.get("housenumber"));
        } catch (Exception e) {
            System.err.println(e);
        }
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

    public static boolean emailValidation(String email) {
        String regex = "([a-zA-Z]([a-zA-Z0-9]*))@([a-zA-Z]{1,})[.]([a-zA-Z]{1,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
