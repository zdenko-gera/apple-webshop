package com.project.webshop.Models;

import com.project.webshop.DAO.ProductDAO;

public class ProductModel {
    private int productID, price, quantity;

    /**
    * Az imagesnek talán jobb lenne egy lista string helyett,
    * de a class diagramon string van, szóval egyelőre így csinálom
     *
     * Zoli, 10.27
    */
    private String productType, name, description, images;
    ProductDAO productDAO;
    public ProductModel(int productID, int price, int quantity, String productType, String name, String description, String images) {
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
        this.name = name;
        this.description = description;
        this.images = images;

        productDAO = new ProductDAO();
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }
}
