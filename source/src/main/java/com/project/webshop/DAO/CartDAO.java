package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import com.project.webshop.Models.ProductModel;
import com.project.webshop.Models.UserModel;
import org.apache.catalina.User;
import org.apache.catalina.valves.JDBCAccessLogValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class CartDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;
    public CartDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
        jdbcTemplate.setQueryTimeout(5);
    }
    /**
     * Visszaadja az email címhez tartozó kosár ID-ját
     * @param email A felhasználó email címe
     * @return A kosár ID-ja
     */
    public int getUserCartID(String email) {
        String sqlCode = "SELECT email, cartID FROM cart WHERE cart.email = ?";
        int cartID = -1;
        try {
            cartID = (int) jdbcTemplate.queryForMap(sqlCode, email).get("cartID");
        } catch (Exception e) {
            System.err.println(e);
        }
        return cartID;
    }
    public boolean insertCart(String email) {
        String sqlCode = "INSERT INTO cart (email) VALUES (?)";
        return jdbcTemplate.update(sqlCode, email) == 1;
    }

    /**
     * Ebben a függvényben van megvalósítva a kosárhoz hozzáadás
     * @param cartID A kosár azonosítója amihez hozzáadunk
     * @param productID A termék azonosító amit hozzáadunk
     * @param quantity darabszám
     */
    public boolean addToCart(int cartID, int productID, int quantity) {
        String sqlCode = "INSERT INTO itemsincart (cartID, productID, quantity) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sqlCode, cartID, productID, quantity) == 1;
    }

    /**
     * Ebben a függvényben van megvalósítva a mennyiség módosítás
     * @param cartID A kosár azonosítója amit frissíteni akarunk
     * @param productID A termék azonosító amit frissítünk
     * @param quantity darabszám
     */
    public void updateQuantityByID(int cartID, String productID, String quantity) {
        String sqlCode = "UPDATE itemsincart SET quantity = ? WHERE cartID = ? AND productID = ?";
        jdbcTemplate.update(sqlCode, quantity, cartID, productID);
    }

    /**
     * Ebben a függvényben van megvalósítva a kosárból törlés
     * @param cartID A kosár azonosítója amiből törlünk
     * @param productID A termék azonosító amit törlünk
     */
    public void removeFromCart(int cartID, int productID) {
        String sqlCode = "DELETE FROM itemsincart WHERE cartID = ? AND productID = ?";
        jdbcTemplate.update(sqlCode, cartID, productID);
    }

    /**
     * @return A kosár tartalma Map formában, melynek kulcsa az adatbázis attribútuma, értéke meg az attribútum értéke
     */
    public List<Map<String, Object>> getCart(String email) {
        String sqlCode = "SELECT product.productID, price, name, description, itemsincart.quantity " +
                         "FROM itemsincart " +
                         "INNER JOIN product ON itemsincart.productID = product.productID " +
                         "INNER JOIN cart ON cart.cartID = itemsincart.cartID " +
                         "WHERE cart.email = ?";
        return jdbcTemplate.queryForList(sqlCode, email);
    }

    public void clearCart(String email) {
        int cartID = getUserCartID(email);
        String sqlCode = "DELETE FROM itemsincart WHERE cartID = ?";
        jdbcTemplate.update(sqlCode, cartID);
    }
}
