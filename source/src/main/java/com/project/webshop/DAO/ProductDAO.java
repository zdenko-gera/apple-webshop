package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import com.project.webshop.Models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Table(name="product")
public class ProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;
    public ProductDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
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
