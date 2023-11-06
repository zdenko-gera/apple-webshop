package com.project.webshop.Controllers;

import com.project.webshop.DAO.UserDAO;
import com.project.webshop.Models.UserModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AdminController extends UserController {
    public void addProduct(String type, int price, String name, String description, int quantity, String images) {

    }

    public void deleteOrder(int orderID) {

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

    @PostMapping(value = "deleteUser")
    public void deleteUser(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        UserDAO userDAO = new UserDAO();
        Object object = session.getAttribute("email");

        if (object != null) {
            userDAO.deleteUser(object.toString());
        }
    }
}
