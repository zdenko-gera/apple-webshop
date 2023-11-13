package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import com.project.webshop.Models.CartModel;
import com.project.webshop.Models.OrderModel;
import com.project.webshop.Models.ProductModel;
import com.project.webshop.Models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
        for (Map<String, Object> item : cartContent) {
            jdbcTemplate.update(insertItemsSQL, maxOrderID, item.get("productID"), item.get("quantity"));
            new ProductDAO().addToQuantityByID((Integer) item.get("productID"), -1 * (Integer) item.get("quantity"));
        }


        return true;
    }

    public List<Map<String, Object>> getOrdersByEmail(String email) {
        String sqlCode = "SELECT orderID, orderDate, price FROM orders WHERE orders.email = ?";
        return jdbcTemplate.queryForList(sqlCode, email);
    }

    public List<Map<String, Object>> getOrderItemsByID(int orderID) {
        String sqlCode = "SELECT product.name, product.price, ordereditems.quantity FROM ordereditems INNER JOIN product ON ordereditems.productID = product.productID WHERE ordereditems.orderID = ?";
        return jdbcTemplate.queryForList(sqlCode, orderID);
    }


    /**
     * Töröl egy meglévő rendelést, ha rövid időn belül törli
     //* @param email A felhasználó email címe
     * @param orderID A rendelés azonosítója
     * @return
     */
    public boolean deleteOrder(int orderID) {
        String sqlCode ="DELETE FROM orders WHERE orderID = ?;";
        return jdbcTemplate.update(sqlCode, orderID) == 1;
    }

    /**
     * Visszaadja egy rendelés OrderModeljét ID alapján.
     * @param id A visszatérítendő rendelés ID-je
     * @return A kért rendelés OrderModellje
     */
    public OrderModel getOrderById(int id) {
        String sqlCode = "SELECT * FROM orders WHERE orderID = ?";
        Map<String, Object> order;
        try {
            order = jdbcTemplate.queryForMap(sqlCode, id);
        } catch (EmptyResultDataAccessException erdae) {
            System.err.println(erdae.toString());
            return null;
        }

        return new OrderModel((int) order.get("orderID"), (int) order.get("price"),
                order.get("email").toString(), (Date) order.get("orderDate"));
    }

    public List<Map<String, Object>> getAllOrders() {
        String sqlCode = "SELECT * FROM orders;";
        return jdbcTemplate.queryForList(sqlCode);
    }
}
