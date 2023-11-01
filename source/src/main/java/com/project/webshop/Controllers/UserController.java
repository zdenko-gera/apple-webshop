package com.project.webshop.Controllers;

import com.project.webshop.DAO.UserDAO;
import com.project.webshop.Models.UserModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    public UserController() {}

    @PostMapping(value="registerUser")
    public String register(@RequestParam("email") String email,
                           @RequestParam("firstname") String firstname,
                           @RequestParam("lastname") String lastname,
                           @RequestParam("password1") String password1,
                           @RequestParam("password2") String password2, HttpServletRequest request) {
        System.out.println(email + " " + firstname + " " + lastname + " " + password1 + " " + password2);
        String error = UserModel.checkRegistrationData(email, firstname, lastname, password1, password2);
        if(error.equals("?error=")) {
            UserModel user = new UserModel(email, password1, firstname, lastname, "user", java.time.LocalDate.now());
            user.getUserDAO().insertUser(user);
            return "redirect:/Signup?reg=success";
        }
        return "redirect:/Signup" + error;
    }

    @PostMapping(value="loginUser")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password, HttpServletRequest request) {
        //Ez a session ez azt csinálja, hogy ha ezt módosítod (pl beleraksz egy email cím kulcshoz egy értéket
        //Akkor legközelebb mikor megkapod a HttpServletRequest-et és abból lekéred a sessiont, akkor abban
        //bennemarad az email cím és az érték, így lehet kezelni azt, hogy be van-e lépve
        HttpSession httpSession = request.getSession(false);
        if(httpSession != null && httpSession.getAttribute("email") != null) {
            return "redirect:/Index?error_loggedIn";
        }

        //Szimplán leellenőrzi azt, hogy megfelelő-e a user belépési adata
        if(new UserDAO().checkCredentials(email, password)) {
            if(httpSession == null) {
                httpSession = request.getSession(true);
            }
            httpSession.setAttribute("email", new UserDAO().getUserDataByEmail(email));
            return "redirect:/Index?login=success";
        }

        return "redirect:/Login";
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
