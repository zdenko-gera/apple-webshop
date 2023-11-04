package com.project.webshop.Controllers;

import com.project.webshop.DAO.UserDAO;
import com.project.webshop.Models.UserModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {
    public UserController() {}

    @PostMapping(value="registerUser")
    public String register(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        boolean error = false;


        if(email == "") {
            model.addAttribute("emailNull", "Email cím megadása kötelező!");
            error = true;
        }
        if(!error && !emailValidation(email)) {
            model.addAttribute("emailFormat", "Email cím formátuma nem megfelelő!");
            error = true;
        }
        if(!error && new UserDAO().getUserDataByEmail(email) != null) {
            model.addAttribute("emailUsed", "Ez az email cím már használatban van!");
            error = true;
        }
        if(!passwordValidation(password1) || !passwordValidation(password2)) {
            model.addAttribute("pwLength", "Jelszó hossza legalább 8 karakter!");
            error = true;
        }
        if(!password1.equals(password2)) {
            model.addAttribute("pwEqual", "A jelszavaknak meg kell egyezniük!");
            error = true;
        }
        if(firstname.trim().equals("") || lastname.trim().equals("")) {
            model.addAttribute("name", "Név megadása kötelező!");
            error = true;
        }

        if(error) return "Signup";

        UserModel user = new UserModel(email, password1, firstname, lastname, "user", java.time.LocalDate.now());
        user.getUserDAO().insertUser(user);
        user.getCartModel().getCartDAO().insertCart(email);
        user.getBillingDetailsModel().getBillingDetailsDAO().insertBillingDetails(email);
        user.getDeliveryDetailsModel().getDeliveryDetailsDAO().insertDeliveryDetails(email);
        return "redirect:/";
    }

    @PostMapping(value="loginUser")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password, HttpServletRequest request, Model model) {
        //Ez a session ez azt csinálja, hogy ha ezt módosítod (pl beleraksz egy email cím kulcshoz egy értéket
        //Akkor legközelebb mikor megkapod a HttpServletRequest-et és abból lekéred a sessiont, akkor abban
        //bennemarad az email cím és az érték, így lehet kezelni azt, hogy be van-e lépve
        HttpSession httpSession = request.getSession(false);
        //Szimplán leellenőrzi azt, hogy megfelelő-e a user belépési adata
        if(new UserDAO().checkCredentials(email, password)) {
            if(httpSession == null) {
                httpSession = request.getSession(true);
            }
            httpSession.setAttribute("email", new UserDAO().getUserDataByEmail(email));
            return "redirect:/";
        }

        model.addAttribute("error", "Hibás email cím és jelszó párosítás!");
        return "Login";
    }

    @GetMapping("logout")
    public String logoutUser(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        if(httpSession != null) {
            //Egyszerűen törli a sessiont
            httpSession.invalidate();
        }
        System.out.println("siker");
        return "redirect:/Index?logout=success";
    }

    public void updateCart(int itemID, int quantity) {

    }

    public void createOrder(int cartID) {

    }

    public void addComment(int productID, String comment, int rating) {

    }
    @PostMapping(value="changePassword")
    public void changePassword(@RequestParam("oldPassword") String oldPassword,
                               @RequestParam("newPassword1") String newPassword1,
                               @RequestParam("newPassword2") String newPassword2) {

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
    public static boolean emailValidation(String email) {
        String regex = "([a-zA-Z]([a-zA-Z0-9]*))@([a-zA-Z]{1,})[.]([a-zA-Z]{1,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static boolean passwordValidation(String password) {
        return password.length() >= 8;
    }
}
