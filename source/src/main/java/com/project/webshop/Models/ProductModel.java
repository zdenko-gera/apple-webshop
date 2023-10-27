package com.project.webshop.Models;

import java.util.Map;

public class ProductModel {
    private int productID, price, quantity;

    /**
    * Az imagesnek talán jobb lenne egy lista string helyett,
    * de a class diagramon string van, szóval egyelőre így csinálom
     *
     * Zoli, 10.27
    */
    private String productType, name, description, images;

    public ProductModel(int productID, int price, int quantity, String productType, String name, String description, String images) {
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
        this.name = name;
        this.description = description;
        this.images = images;
    }


    /**
     * A termék létrehozása az adatbázisban.
     * @param name A termék neve
     * @param description A termék leírása
     * @param productType A termék típusa
     * @param price A termék ára
     * @param quantity A raktáron lévő darabszám
     * @return true ha sikeres a hozzáadás, false ha nem
     */
    public boolean createProduct(String name, String description, String productType, int price, int quantity) {
        return false;
    }

    /**
     * Visszaadja egy adott termék ProdectModeljét
     * @param name A termék neve
     * @return egy termék ProductModeljét
     */
    public ProductModel getProduct(String name) {
        return null;
    }

    /**
     * Törli az adott nevű terméket az adatbázisból
     * @param name A törlendő termék neve
     * @return true ha sikeres a törlés, false ha nem
     */
    public boolean deleteProduct(String name) {
        return false;
    }

    /**
     * Elvégzi a termék adatainak módosítását
     * @param name A termék neve
     * @param description A termék leírása
     * @param productType A termék típusa
     * @param price A termék ára
     * @param quantity A termék darabszáma
     * @return true ha sikeres a módosítása, false egyébként
     */
    public boolean updateProduct(String name, String description, String productType, int price, int quantity) {
        return false;
    }
}
