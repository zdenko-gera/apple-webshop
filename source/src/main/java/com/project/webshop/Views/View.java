package com.project.webshop.Views;

import com.project.webshop.Models.UserModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping("Cart")
    public String Cart() {
        return "Cart.html";
    }
    @GetMapping("Webshop")
    public String Webshop() {
        return "Webshop.html";
    }
    @GetMapping("Productpage")
    public String Productpage() {
        return "Productpage.html";
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
