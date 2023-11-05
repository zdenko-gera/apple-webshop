package com.project.webshop.Controllers;

import com.project.webshop.Models.ProductModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

public class AdminController extends UserController {
    @PostMapping("createProduct")
    @ResponseBody
    public String addProduct(@RequestParam String type,@RequestParam int price,@RequestParam String name,@RequestParam String description,
                           @RequestParam int quantity,@RequestParam ArrayList<String> images, Model model) {
        boolean error = false;

        if(type.equals("")) {
            model.addAttribute("emptyFieldType", "Típus megadása kötelező!");
            error = true;
        }
        if(price == 0) {
            model.addAttribute("emptyFieldPrice", "Ár megadása kötelező!");
            error = true;
        }
        if(name.equals("")) {
            model.addAttribute("emptyFieldName", "Terméknév megadása kötelező!");
            error = true;
        }
        if(images.size() == 0) {
            model.addAttribute("emptyFieldImages", "Minimum 1 db kép megadása kötelező!");
            error = true;
        }

        if(error) return "Admin";

        ProductModel product = new ProductModel(price,quantity,type,name,description,images);
        return "redirect:/";

    }

    public void deleteOrder(int orderID) {

    }

    public void shipOrder(int orderID) {

    }

    public void deleteComment(int commentID) {

    }

    public void deleteUser(String email) {

    }

}
