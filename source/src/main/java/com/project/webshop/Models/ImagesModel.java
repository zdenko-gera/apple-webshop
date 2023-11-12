package com.project.webshop.Models;

import org.springframework.data.relational.core.mapping.Table;
import com.project.webshop.DAO.ProductDAO;
import java.util.ArrayList;

public class ImagesModel {
    private String imagePath;
    ProductDAO productDAO;

    public ImagesModel(String imagePath) {
        this.imagePath = imagePath;

        productDAO = new ProductDAO();
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
