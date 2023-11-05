package com.project.webshop.Controllers;

import com.project.webshop.DAO.ProductDAO;
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

    /**
     * Paraméterben kapott értékek alapján megnézi, hogy létezik-e az adott nevű termék, ha igen akkor
     * beállítja az új árat.
     * @param name a termék neve
     * @param price az új ár
     */
    public void updateProductPriceByName(@RequestParam("name") String name, @RequestParam("price") int price){
        ProductDAO productDAO = new ProductDAO();
        ProductModel productModel = productDAO.getProductByName(name);
        if(productModel != null){
            productDAO.updateProductPrice(productModel, price);
        }
    }

    /**
     * Paraméterben kapott értékek alapján megnézi, hogy létezik-e az adott nevű termék, ha igen akkor
     * beállítja az új típusát.
     * @param name a termék neve
     * @param type az új típus
     */
    public void updateProductTypeByName(@RequestParam("name") String name, @RequestParam("type") String type){
        ProductDAO productDAO = new ProductDAO();
        ProductModel productModel = productDAO.getProductByName(name);
        if(productModel != null){
            productDAO.updateProductType(productModel, type);
        }
    }

    /**
     * Paraméterben kapott értékek alapján megnézi, hogy létezik-e az adott nevű termék, ha igen akkor
     * beállítja az új leírását.
     * @param name a termék neve
     * @param description az új leírás
     */
    public void updateProductDescriptionByName(@RequestParam("name") String name, @RequestParam("description") String description){
        ProductDAO productDAO = new ProductDAO();
        ProductModel productModel = productDAO.getProductByName(name);
        if(productModel != null){
            productDAO.updateProductDescription(productModel, description);
        }
    }

    /**
     * Paraméterben kapott értékek alapján megnézi, hogy létezik-e az adott nevű termék, ha igen akkor
     * beállítja az új nevét.
     * @param name a termék régi neve
     * @param newname az új név
     */
    public void updateProductNameByName(@RequestParam("name") String name, @RequestParam("newname") String newname){
        ProductDAO productDAO = new ProductDAO();
        ProductModel productModel = productDAO.getProductByName(name);
        if(productModel != null){
            productDAO.updateProductName(productModel, newname);
        }
    }

    /**
     * Paraméterben kapott értékek alapján megnézi, hogy létezik-e az adott nevű termék, ha igen akkor
     * beállítja az új raktáron lévő mennyiségét.
     * @param name a termék neve
     * @param quantity az új mennyiség
     */
    public void updateProductQuantityByName(@RequestParam("name") String name, @RequestParam("quantity") int quantity){
        ProductDAO productDAO = new ProductDAO();
        ProductModel productModel = productDAO.getProductByName(name);
        if(productModel != null){
            productDAO.updateProductQuantity(productModel, quantity);
        }
    }

    /**
     * Paraméterben kapott értékek alapján megnézi, hogy létezik-e az adott nevű termék, ha igen akkor
     * beállítja az új értékeket.
     * @param name a termék neve
     * @param type az új típus
     * @param price az új ár
     * @param description az új leírás
     * @param quantity az új mennyiség
     */
    public void updateProductByName(@RequestParam("name") String name, @RequestParam("type") String type, @RequestParam("price") int price,
                                    @RequestParam("description") String description, @RequestParam("quantity") int quantity){
        ProductDAO productDAO = new ProductDAO();
        ProductModel productModel = productDAO.getProductByName(name);
        if(productModel != null){
            productDAO.updateProduct(productModel, type, price, description, quantity);
        }
    }

    /**
     * Kitörli az adatbázisból a megadott nevű terméket amennyiben az létezik.
     * @param name a termék neve
     */
    public void deleteProductByName(@RequestParam("name") String name){
        ProductDAO productDAO = new ProductDAO();
        ProductModel productModel = productDAO.getProductByName(name);
        if(productModel != null){
            productDAO.deleteProduct(name);
        }
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
