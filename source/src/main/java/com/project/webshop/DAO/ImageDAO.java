package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Table(name="images")
public class ImageDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;
    public ImageDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
        jdbcTemplate.setQueryTimeout(5);
    }

    /**
     * Visszaadja az images táblából az adott productID-vel rendelkező adatokat.
     * @param productID keresett termékazonosító
     * @return
     */
    public List<Map<String, Object>> getImage(int productID) {
        String sqlCode = "SELECT * FROM images WHERE productID = ?";
        return jdbcTemplate.queryForList(sqlCode, productID);
    }

    public void newImage(int productID, String fileName) {
        String sqlCode = "INSERT INTO images (imagePath, productID) VALUES (?, ?)";
        jdbcTemplate.update(sqlCode, fileName, productID);
    }
}
