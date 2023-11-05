package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import com.project.webshop.Models.ProductModel;
import com.project.webshop.Models.UserModel;
import com.project.webshop.SpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

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
        String sqlCode = "INSERT INTO product (productType, price, name, description, quantity) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sqlCode, name,description,productType,price, quantity) == 1;
    }

    /**
     * Visszaadja egy adott termék ProductModeljét
     * @param name A termék neve
     * @return egy termék ProductModeljét
     */
    public ProductModel getProduct(String name) {
        String sqlCode = "SELECT * FROM product WHERE product.name = ?";
        Map<String, Object> product;
        try {
            product = jdbcTemplate.queryForMap(sqlCode, name);
        } catch (EmptyResultDataAccessException erdae) {
            System.err.println(erdae.toString());
            return null;
        }

        return new ProductModel((int) product.get("productID"), (int) product.get("price"), (int) product.get("quantity"),
                product.get("productType").toString(), product.get("name").toString(),product.get("description").toString(),
                (ArrayList<String>) product.get("images"));
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
