package com.project.webshop.Views;

import com.project.webshop.DAO.CartDAO;
import com.project.webshop.DAO.ProductDAO;
import com.project.webshop.Models.UserModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class View {
    @GetMapping("Index")
    public String index() {
		return "index.html";
    }

    @GetMapping("Login")
    public String Login(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        if(httpSession != null && httpSession.getAttribute("email") != null) {
            return "redirect:/Index?error=loggedIn";
        }
        return "Login.html";
    }
    @GetMapping("Shops")
    public String Shops() {
        return "Shops.html";
    }

    @GetMapping("Profil")
    public String Profil() {
        return "Profil.html";
    }

    @GetMapping("Info")
    public String Info() {
        return "info.html";
    }

    @GetMapping("ÁSZF")
    public String ÁSZF() {
        return "ÁSZF.html";
    }

    /**
     * Megnézi, hogy be van-e jelentkezve a felhasználó, ha nincs átirányítja a Login oldalra. Ha bevan,
     * a sessionből lekéri az adatait, és az adatbázisból a kosár tartalmát, és egy listában eltárolja.
     * Összeszámolja a teljes árat a fullprice változóba, és a listát illetve a teljes árat a modelben belerakja
     * egy attribútumba, amivel megjeleníthetjük dinamikusan a kosarat a felhasználónak.
     * @param request Ebből kérjük le a sessiont, amiben a felhasználó adatai vannak
     * @param model Ezzel adunk adatot át a thymeleafnek
     * @return
     */
    @GetMapping("Cart")
    public String Cart(HttpServletRequest request, Model model) {
        if(request.getSession() == null || request.getSession().getAttribute("email") == null) {
            return "Login";
        }

        UserModel user = (UserModel) request.getSession().getAttribute("email");
        List<Map<String, Object>> cartContent = user.getCartModel().getCartDAO().getCart(user.getEmail());

        int fullprice = 0;
        for (Map<String, Object> stringObjectMap : cartContent) {
            fullprice += (Integer) stringObjectMap.get("price");
        }

        model.addAttribute("items", cartContent);
        model.addAttribute("fullprice", fullprice);

        return "Cart.html";
    }

    /**
     * A paraméterben kapott modelhez hozzáadja az összes terméket egy attribútum formájában, és ezt a listát a
     * thymeleaf-fel lehet elérni, és dinamikusan megjeleníteni a tartalmat az oldalon
     * @param model Ezzel lehet adatot átadni a frontendnek, és thymeleaffel elérni (vagy valami ilyesmi)
     * @return A weboldal neve, amire át akarjuk irányítani a felhasználót
     */
    @GetMapping("Webshop")
    public String Webshop(Model model) {
        List<Map<String, Object>> products = new ProductDAO().getProducts();
        model.addAttribute("products", products);
        return "Webshop.html";
    }

    @GetMapping("Productpage")
    public String Productpage(HttpServletRequest request, Model model) {
        int productID = Integer.parseInt(request.getParameter("productID"));
        Map<String, Object> product = new ProductDAO().getProduct(productID);
        model.addAttribute("product", product);
        return "Productpage";
    }

    @GetMapping("Signup")
    public String Signup(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        if(httpSession != null && httpSession.getAttribute("email") != null) {
            return "redirect:/Index?error=loggedIn";
        }
        return "Signup.html";
    }

    @GetMapping("Block")
    public String Block(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        UserModel userModel = null;
        if(httpSession != null) {
            userModel = (UserModel) httpSession.getAttribute("email");
        }

        if(userModel == null || userModel.getEmail() == null || !userModel.getRole().equals("admin")) {
            return "redirect:/Index?error=noPermission";
        }
        return "Block.html";
    }

    @GetMapping("Admin_user")
    public String Admin_user(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        UserModel userModel = null;
        if(httpSession != null) {
            userModel = (UserModel) httpSession.getAttribute("email");
        }

        if(userModel == null || userModel.getEmail() == null || !userModel.getRole().equals("admin")) {
            return "redirect:/Index?error=noPermission";
        }
        return "Admin_user.html";
    }

    @GetMapping("Admin_order")
    public String Admin_order(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        UserModel userModel = null;
        if(httpSession != null) {
            userModel = (UserModel) httpSession.getAttribute("email");
        }

        if(userModel == null || userModel.getEmail() == null || !userModel.getRole().equals("admin")) {
            return "redirect:/Index?error=noPermission";
        }
        return "Admin_order.html";
    }

    @GetMapping("Admin")
    public String Admin(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(false);
        UserModel userModel = null;
        if(httpSession != null) {
            userModel = (UserModel) httpSession.getAttribute("email");
        }

        if(userModel == null || userModel.getEmail() == null || !userModel.getRole().equals("admin")) {
            return "redirect:/Index?error=noPermission";
        }
        return "Admin.html";
    }
}
