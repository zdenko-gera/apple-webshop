package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import com.project.webshop.Models.CartModel;
import com.project.webshop.Models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Table(name="orders")
public class OrderDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;
    public OrderDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
        jdbcTemplate.setQueryTimeout(5);
    }

    /**
     * Egy új rendelést ad hozzá az adatbázishoz
     * @param user A felhasználó Modelje
     * @return
     */
    public boolean createOrder(UserModel user) {
        String email = user.getEmail();
        List<Map<String, Object>> cartContent = user.getCartModel().getCartDAO().getCart(email);

        String insertOrderSQL = "INSERT INTO orders (email, price, orderDate) VALUES (?,?,?)";
        int fullprice = 0;
        for (Map<String, Object> item : cartContent) {
            fullprice += (Integer) item.get("price") * (Integer) item.get("quantity");
        }
        jdbcTemplate.update(insertOrderSQL, email, fullprice, java.time.LocalDate.now());

        String largestID = "SELECT orderID FROM orders WHERE orders.email = ? ORDER BY orderID DESC LIMIT 1";
        int maxOrderID = 1;
        try {
            maxOrderID = (int) jdbcTemplate.queryForMap(largestID, email).get("orderID");
        } catch (Exception e) {
            System.err.println("Nem talált megfelelő sort az adatbázisban: [Tábla: orders] [attribútum: orderID]");
        }

        String insertItemsSQL = "INSERT INTO ordereditems (orderID, productID, quantity) VALUES (?,?,?)";
        String removeItemFromProduct = "UPDATE product SET quantity = ((SELECT quantity FROM product WHERE productID = ?) - ?) WHERE productID = ?";
        for (Map<String, Object> item : cartContent) {
            jdbcTemplate.update(insertItemsSQL, maxOrderID, item.get("productID"), item.get("quantity"));
            jdbcTemplate.update(removeItemFromProduct, item.get("productID"), item.get("quantity"), item.get("productID"));
        }


        return true;
    }

    /**
     * Töröl egy meglévő rendelést, ha rövid időn belül törli
     * @param email A felhasználó email címe
     * @param orderID A rendelés azonosítója
     * @return
     */
    public boolean deleteOrder(String email, int orderID) {
        return false;
    }
}
