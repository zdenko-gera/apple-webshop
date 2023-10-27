package com.project.webshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class helloController {
    @GetMapping("index")
    public String index() {
		return "index.html";
    }
    @GetMapping("Login")
    public String Login() {
        return "Login.html";
    }
    @GetMapping("Signup")
    public String Signup() {
        System.out.println("halo");
        return "Signup.html";
    }
}
