package com.project.webshop.Models;

import com.project.webshop.DAO.ProductDAO;

import java.util.ArrayList;

public class ProductModel {
    private int productID, price, quantity;

    /**
    * Az imagesnek talán jobb lenne egy lista string helyett,
    * de a class diagramon string van, szóval egyelőre így csinálom
     *
     * Zoli, 10.27
    */

    /**
     * Arraylist típust adtam az imagesnek a jobb használhatóság érdekében.
     *
     * Zdenkó, 11.04.
     *
     * ProductId adattagot 'eltávolítottam', mert AUTO_INCREMENT tulajdonságú az adatbázisban
     *
     * Zdenkó, 11.05.
     */
    private String productType, name, description;
    private ArrayList<String> images;
    ProductDAO productDAO;
    public ProductModel(int price, int quantity, String productType, String name, String description, ArrayList<String> images) {
        //this.productID = productID;
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

    /*public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }*/

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
