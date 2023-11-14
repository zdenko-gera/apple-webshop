package com.project.webshop.Controllers;

import com.project.webshop.DAO.OrderDAO;
import com.project.webshop.DAO.ProductDAO;
import com.project.webshop.DAO.UserDAO;
import com.project.webshop.Models.OrderModel;
import com.project.webshop.Models.ProductModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Controller
public class AdminController {
    @PostMapping(value="createProduct")
    @ResponseBody
    public String addProduct(@RequestParam String type, @RequestParam int price, @RequestParam String name, @RequestParam String description,
                             @RequestParam int quantity, @RequestParam ArrayList <MultipartFile> images, Model model) {
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

        if(error) return "Admin";

        ProductModel product = new ProductModel(price,quantity,type,name,description,images);
        product.getProductDAO().createProduct(type,price,name,description,quantity);
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

    /**
     * Kitörli az adatbázisból az adott ID-vel rendelkező rendelést, amennyiben az létezik.
     * @param orderID a rendelés azonosítója
     */
    @PostMapping(value="deleteOrder")
    public String deleteOrder(@RequestParam("orderID") int orderID) {
        OrderDAO orderDAO = new OrderDAO();
        OrderModel orderModel = orderDAO.getOrderById(orderID);
        if(orderModel != null) {
            orderDAO.deleteOrder(orderID);
        }
        return "redirect:/Admin_order";
    }

    public void shipOrder(int orderID) {

    }

    public void deleteComment(int commentID) {

    }

    /**
     * Lekérdezi a felhasználó emailjét a sessionből. Ez alapján beazonosítja a felhasználót az adatbázisban
     * (amennyiben létezik), majd törli az adatait.
     * @param request
     */

    @PostMapping(value = "deleteUserByAdmin")
    public String deleteUser(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        UserDAO userDAO = new UserDAO();
        Object object = session.getAttribute("email");

        if (object != null) {
            userDAO.deleteUser(object.toString());
        }
        return "redirect:/";
    }
}
