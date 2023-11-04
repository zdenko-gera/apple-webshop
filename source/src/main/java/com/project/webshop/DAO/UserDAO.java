package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import com.project.webshop.Models.UserModel;
import com.project.webshop.SpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.Map;

@Table(name="user")
public class UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;

    public UserDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
    }

    /**
     * Ez a függvény valósítja meg egy új felhasználó regisztrációját
     * @param userModel A felhasználóról készült objektum
     * @return true ha sikeres regisztráció, false ha nem
     */
    public boolean insertUser(UserModel userModel) {
        String sqlCode = "INSERT INTO user (email, firstname, lastname, password, registrationDate, role) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update(sqlCode, userModel.getEmail(),
                userModel.getFirstname(),
                userModel.getLastname(),
                SpringSecurity.passwordEncoder().encode(userModel.getPassword()),
                userModel.getRegistrationDate(), "user") == 1;
    }

    /**
     * A felhasználó bejelentkezését kezelő függvény
     * @param email A felhasználó email címe
     * @param password A fiók jelszava
     * @return true ha sikeres a bejelentkezés, false ha nem
     */
    public boolean checkCredentials(String email, String password) {
        UserModel user = getUserDataByEmail(email);
        if(user == null) {
            return false;
        }

        return SpringSecurity.passwordEncoder().matches(password, user.getPassword());
    }

    /**
     * Ez a függvény valósítja meg a felhasználói fiók törlését
     * @param email A törlendő fiók email címe
     * @param password A törlendő fiók jelszava (biztonsági okok miatt)
     * @return true ha sikeres a törlés, false ha nem
     */
    public boolean deleteUser(String email, String password) {
        return false;
    }

    public UserModel getUserDataByEmail(String email) {
        String sqlCode = "SELECT * FROM user WHERE user.email = ?";
        Map<String, Object> user;
        try {
            user = jdbcTemplate.queryForMap(sqlCode, email);
        } catch (EmptyResultDataAccessException erdae) {
            System.err.println(erdae.toString());
            return null;
        }

        return new UserModel(user.get("email").toString(),
                                            user.get("password").toString(),
                                            user.get("firstname").toString(),
                                            user.get("lastname").toString(),
                                            user.get("role").toString(),
                                            LocalDate.parse(user.get("registrationDate").toString()));
    }
}
