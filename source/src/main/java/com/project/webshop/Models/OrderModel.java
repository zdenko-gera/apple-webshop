package com.project.webshop.Models;

import com.project.webshop.DAO.OrderDAO;

import java.time.LocalDateTime;
import java.util.List;

public class OrderModel {
    private int orderID, price;
    private String email;
    private LocalDateTime orderDate;
    private List<ProductModel> orderedItems;

    OrderDAO orderDAO;
    public OrderModel(int orderID, int price, String email, LocalDateTime orderDate, List<ProductModel> orderedItems) {
        this.orderID = orderID;
        this.price = price;
        this.email = email;
        this.orderDate = orderDate;
        this.orderedItems = orderedItems;
        orderDAO = new OrderDAO();
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }
}
