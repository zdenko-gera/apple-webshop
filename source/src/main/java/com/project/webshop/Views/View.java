package com.project.webshop.Views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class View {
    @GetMapping("index")
    public String index() {
		return "index.html";
    }
    @GetMapping("Login")
    public String Login() {
        return "Login.html";
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
    public String Signup() {
        return "Signup.html";
    }

    @GetMapping("Block")
    public String Block() {
        return "Block.html";
    }

    @GetMapping("Admin_user")
    public String Admin_user() {
        return "Admin_user.html";
    }

    @GetMapping("Admin_order")
    public String Admin_order() {
        return "Admin_order.html";
    }

    @GetMapping("Admin")
    public String Admin() {
        return "Admin.html";
    }
}
