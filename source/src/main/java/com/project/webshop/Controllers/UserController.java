package com.project.webshop.Controllers;

import com.project.webshop.DAO.CartDAO;
import com.project.webshop.DAO.UserDAO;
import com.project.webshop.DAO.OrderDAO;
import com.project.webshop.Models.CartModel;
import com.project.webshop.Models.UserModel;
import com.project.webshop.SpringSecurity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
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

    /**
     * Megvalósítja a felhasználó regisztrációját. A request paraméteren keresztül lekéri a formból az adatokat.
     * Ezután ellenőrzi, hogy megfelelőek-e. Ha van error, belerakja a Modelbe, majd returnöl a "Signup" oldalra.
     * Ekkor megmarad a Model, és abból lehet visszajelezni a felhasználónak a hibaüzeneteket Thymeleaf segítségével.
     * Ha helyesek az adatok, akkor létrehoz egy Usert és hozzáadja az adatbázishoz, illetve az alap adatokat is létrehozza.
     * @param request Ez egy olyan cucc, amit amikor a felhasználó be akar regisztrálni, kapunk egy ilyet, és ebben vannak benne bizonyos adatok, például a session is ebből kérhető le
     * @param model Ez hasonló ahhoz, a felhasználó elküld egy Modelt, és ebbe is lehet adatokat írni, amit thymeleaffel meg lehet jeleníteni. Hibaüzenet kezelésre van használva
     * @return Egy olyan string, ami átirányít az azonos nevű html oldalra.
     */
    @PostMapping(value="registerUser")
    public String register(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        boolean error = false;


        if(email.equals("")) {
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

    /**
     * Megvalósítja a felhasználó bejelentkezését. A request paraméteren keresztül lekéri a formból az adatokat,
     * illetve egy HttpSessiont (false paraméterrel. ez annyit csinál, hogy lekérdezi, de nem készít újat).
     * Ezután ellenőrzi, hogy megfelelőek-e a belépési adatok. Ha helyesek az adatok, akkor megnézi, hogy van-e session,
     * és ha nincs, létrehoz egyet true paraméterrel, és a sessionhöz hozzáadja az emailcímet, és a UserModel adatait.
     * Ha hibásak az adatok, belerakja a Modelbe, majd returnöl a "Signup" oldalra. Ekkor megmarad a Model,
     * és abból lehet megjeleníteni Thymeleaf segítségével visszajelzést.
     * @param request Ez egy olyan cucc, amit amikor a felhasználó be akar regisztrálni, kapunk egy ilyet, és ebben vannak benne bizonyos adatok, például a session is ebből kérhető le
     * @param model Ez hasonló ahhoz, a felhasználó elküld egy Modelt, és ebbe is lehet adatokat írni, amit thymeleaffel meg lehet jeleníteni. Hibaüzenet kezelésre van használva
     * @return Egy olyan string, ami átirányít az azonos nevű html oldalra.
     */
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

    /**
     * Ez megvalósítja a felhasznalo kijelentkezését. lekéri a sessiont false paraméterrel (nem csinál újat).
     * Ha nem null, tehát van session, akkor invalidateli azt, tehát kijelentkezteti a felhasználót.
     * @param request Ebben van eltárolva a session is többek között
     * @return Egy stringet, ami redirectel a főoldalra.
     */
    @GetMapping("logout")
    public String logoutUser(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        if(httpSession != null) {
            //Egyszerűen törli a sessiont
            httpSession.invalidate();
        }

        return "redirect:/Index?logout=success";
    }

    /**
     * Hozzáad egy új terméket a kosárhoz, amennyiben a felhasználó be van jelentkezve. Lekéri a termék ID-ját egy hidden
     * inputon keresztül, illetve a darabszámot, megnézi, hogy a termék a kosárban van-e, (ha igen nem csinál semmit), és ha
     * nincs akkor hozzáadja. Azt, hogy benne van-e a kosárban nem az adatbázisból kéri le, hanem a sessionből lekéri a
     * UserModelt, és abból a CartModelt, és abban nézi meg. Ez utóbbi csak a productID-kat és darabszámokat tartalmazza.
     * @param request Ebben van eltárolva a session is többek között, ami ahhoz kell, hogy be van-e jelentkezve a felhasználó
     * @return Egy stringet ami átdobja a felhasználót a kosár oldalra.
     */
    @PostMapping("addToCart")
    public String addToCart(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null || httpSession.getAttribute("email") == null) {
            return "Login";
        }

        int productID = Integer.parseInt(request.getParameter("productID"));
        int quantity = 0;
        if(!request.getParameter("quantity").equals("")) {
            quantity = Integer.parseInt(request.getParameter("quantity"));
        }
        if(quantity <= 0) {
            return "redirect:/Webshop";
        }

        UserModel user = (UserModel) httpSession.getAttribute("email");
        CartModel cart = user.getCartModel();

        if(!user.getCartModel().hasItem(productID)) {
            cart.addItemToCart(productID, quantity);
            cart.getCartDAO().addToCart(cart.getCartID(), productID, quantity);
        }

        return "redirect:/Cart";
    }
    public String removeFromCart(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null || httpSession.getAttribute("email") == null) {
            return "Login";
        }

        int productID = Integer.parseInt(request.getParameter("productID"));

        UserModel user = (UserModel) httpSession.getAttribute("email");
        CartModel cart = user.getCartModel();

        if(!user.getCartModel().hasItem(productID)) {
            cart.removeItemFromCart(productID);
            cart.getCartDAO().removeFromCart(cart.getCartID(), productID);
        }

        return "redirect:/Cart";
    }

    public String updateCart(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null || httpSession.getAttribute("email") == null) {
            return "Login";
        }

        UserModel user = (UserModel) httpSession.getAttribute("email");
        int newQuantity = (Integer) request.getAttribute("newQuantity");
        int productID = (Integer) request.getAttribute("productID");
        int cartID = user.getCartModel().getCartID();
        if(newQuantity > 0) {
            user.getCartModel().getCartDAO().updateQuantityByID(cartID, productID, newQuantity);
        }

        return "Cart";
    }

    @PostMapping("createOrder")
    public String createOrder(HttpServletRequest request, Model model) {
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null || httpSession.getAttribute("email") == null) {
            return "Login";
        }

        UserModel user = (UserModel) httpSession.getAttribute("email");
        new OrderDAO().createOrder(user);


        user.getCartModel().getCartDAO().clearCart(user.getEmail());
        user.getCartModel().clearCart();
        return "Index";
    }

    public void addComment(int productID, String comment, int rating) {

    }

    /**
     * Lekérdezi a felhasználó emailjét a sessionből. Ez alapján beazonosítja a felhasználót az adatbázisban (amennyiben létezik
     * a felhasználó), majd lekéri az adatait. Leellenőrzi, hogy a formban megadott régi jelszó egyezik-e a user jelenlegi jelszavával.
     * Ezt a SpringSecurity.passwordEncoder().matches(raw, hashed) függvény oldja meg. Azt is leellenőrzi, hogy a 2 megadott új
     * jelszó megegyezik-e.
     * @param oldPassword
     * @param newPassword1
     * @param newPassword2
     * @param request
     */
    @PostMapping(value="changePassword")
    public String changePassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword1") String newPassword1,
                               @RequestParam("newPassword2") String newPassword2, HttpServletRequest request, Model model) {

        HttpSession httpSession = request.getSession(false);
        UserDAO userDAO = new UserDAO();
        Object email = httpSession.getAttribute("email");
        boolean error = false;

        if(email == null){
            model.addAttribute("emailNull", "Váratlen hiba történt!");
            error = true;
            return "redirect:/";
        }
        if(!userDAO.checkCredentials(email.toString(), oldPassword)){
            model.addAttribute("wrongPw", "A megadott jelszó nem egyezik");
            error = true;
        }
        if(!newPassword1.equals(newPassword2)){
            model.addAttribute("pwNoMatch", "Az új jelszavak nem egyeznek!");
            error = true;
        }
        if(!passwordValidation(newPassword1) || !passwordValidation(newPassword2)) {
            model.addAttribute("pwNotValid", "A jelszónak 8 karakternél hosszabbnak kell lennie!");
            error = true;
        }

        if(error){
            return "Profil"; //ezt meg kell változtatni, ha a profil oldal más nevet kap majd!!!!
        }

        UserModel user = userDAO.getUserDataByEmail(email.toString());
        userDAO.updateUserPasswordByEmail(user, oldPassword, newPassword1, newPassword2);
        return "redirect:/";
    }

    /**
     * Lekérdezi a felhasználó emailjét a sessionből. Ez alapján beazonosítja a felhasználót az adatbázisban
     * (amennyiben létezik), majd lekéri az adatait.
     * @param firstname
     * @param lastname
     * @param request
     */
    @PostMapping(value="changeName")
    public String changeName(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname
            , HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        UserDAO userDAO = new UserDAO();
        Object email = session.getAttribute("email");
        boolean error = false;

        if(email == null){
            model.addAttribute("emailNull", "Váratlen hiba történt!");
            error = true;
            return "redirect:/";
        }
        if(lastname.length() < 1 || !lastname.matches(".*[A-Za-z-9].*")){
            model.addAttribute("wrongLastName", "A megadott utónév nem megfelelő formátumú");
            error = true;
        }
        if(firstname.length() < 1 || !firstname.matches(".*[A-Za-z-9].*")){
            model.addAttribute("wrongFirstName", "A megadott keresztnév nem megfelelő formátumú");
            error = true;
        }

        if(error) return "Profil"; //ezt meg kell változtatni, ha a profil oldal más nevet kap majd!!!!

        UserModel user = userDAO.getUserDataByEmail(email.toString());
        userDAO.updateUserNameByEmail(user, firstname, lastname);
        return "redirect:/";
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
