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
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Table(name="product")
public class ProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;
    public ProductDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
        jdbcTemplate.setQueryTimeout(5);
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
     * Módosítjta a termék árát a neve alapján.
     * @param productModel a termék (modelje)
     * @param price új ár
     */
    public void updateProductPrice(ProductModel productModel, int price){
        productModel.setPrice(price);
        String sqlCode = "update product set price = "+price+" where name = '"+productModel.getName()+"';";
        jdbcTemplate.update(sqlCode);
    }

    /**
     * Módosítjta a termék típusát a neve alapján.
     * @param productModel a termék (modelje)
     * @param type az új típus
     */
    public void updateProductType(ProductModel productModel,String type){
        productModel.setProductType(type);
        String sqlCode = "update product set type = '"+type+"' where name = '"+productModel.getName()+"';";
        jdbcTemplate.update(sqlCode);
    }

    /**
     * Módosítjta a termék nevét a neve alapján.
     * @param productModel a termék (modelje)
     * @param newname az új név
     */
    public void updateProductName(ProductModel productModel,String newname){
        String sqlCode = "update product set type = '"+newname+"' where name = '"+productModel.getName()+"';";
        jdbcTemplate.update(sqlCode);
        productModel.setName(newname);
    }

    /**
     * Módosítjta a termék leírását a neve alapján.
     * @param productModel a termék (modelje)
     * @param description az új leírás
     */
    public void updateProductDescription(ProductModel productModel,String description){
        productModel.setDescription(description);
        String sqlCode = "update product set description = '"+description+"' where name = '"+productModel.getName()+"';";
        jdbcTemplate.update(sqlCode);
    }

    /**
     * Módosítjta a termék raktáron lévő darabjainak a számát a neve alapján.
     * @param productModel a termék (modelje)
     * @param quantity az új darabszám
     */
    public void updateProductQuantity(ProductModel productModel,int quantity){
        productModel.setQuantity(quantity);
        String sqlCode = "update product set quantity = "+quantity+" where name = '"+productModel.getName()+"';";
        jdbcTemplate.update(sqlCode);
    }

    /**
     * Visszaadja egy adott termék ProductModeljét
     * @param name A termék neve
     * @return egy termék ProductModeljét
     */
    //Átneveztem getProductByName-re, hogy egyértelmű legyen mi alapján kéri le a terméket - Dominik 11.05.
    public ProductModel getProductByName(String name) {
        String sqlCode = "SELECT * FROM product WHERE product.name = ?";
        Map<String, Object> product;
        try {
            product = jdbcTemplate.queryForMap(sqlCode, name);
        } catch (EmptyResultDataAccessException erdae) {
            System.err.println(erdae.toString());
            return null;
        }

        return new ProductModel((int) product.get("price"), (int) product.get("quantity"),
                product.get("productType").toString(), product.get("name").toString(),product.get("description").toString(),
                (ArrayList<MultipartFile>) product.get("images"));
    }


    /**
     * Visszaadja egy adott termék ProdectModeljét az ID-ja alapján
     * @param productID A termék ID-ja
     * @return egy termék ProductModelje
     */
    public Map<String, Object> getProduct(int productID) {
        String sqlCode = "SELECT * FROM product WHERE productID = ?";
        return jdbcTemplate.queryForList(sqlCode, productID).get(0);
    }

    /**
     * Visszaadja az összes terméket egy lista formájában amiben Map-ek vannak melynek kulcsa az attribútum neve
     * az adatbázisban, értéke meg az attribútum értéke
     * @return A termékek listába rakva
     */
    public List<Map<String, Object>> getProducts() {
        String sqlCode = "SELECT * FROM product";
        return jdbcTemplate.queryForList(sqlCode);
    }

    /**
     * Törli az adott nevű terméket az adatbázisból
     * @param name A törlendő termék neve
     */
    public void deleteProduct(String name) {
        String sqlCode ="DELETE FROM product WHERE product.name ='"+name+"';";
        jdbcTemplate.update(sqlCode);
    }

    /**
     * Elvégzi a termék adatainak módosítását egyben a termék neve alapján
     * @param productModel a termék (modelje)
     * @param description A termék leírása
     * @param type A termék típusa
     * @param price A termék ára
     * @param quantity A termék darabszáma
     */
    public void updateProduct(ProductModel productModel, String type, int price, String description, int quantity) {
        productModel.setQuantity(quantity);
        productModel.setDescription(description);
        productModel.setProductType(type);
        productModel.setPrice(price);
        String sqlCode = "update product set type=?, price=? description=? quantity=? where name=?";
        jdbcTemplate.update(sqlCode, type, price, description, quantity, productModel.getName());
    }

    public void addToQuantityByID(int productID, int count) {
        String removeItemFromProduct = "UPDATE product SET quantity = ((SELECT quantity FROM product WHERE productID = ?) + ?) WHERE productID = ?";

        jdbcTemplate.update(removeItemFromProduct, productID, count, productID);

    }
}
