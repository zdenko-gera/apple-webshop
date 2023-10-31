package com.project.webshop.DAO;

import com.project.webshop.AppConfig;
import com.project.webshop.Models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Table(name="user")
public class UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    AppConfig appConfig;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public UserDAO() {
        appConfig = new AppConfig();
        jdbcTemplate = new JdbcTemplate(appConfig.getDataSource());
        passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Ez a függvény valósítja meg egy új felhasználó regisztrációját
     * @param userModel A felhasználóról készült objektum
     * @return true ha sikeres regisztráció, false ha nem
     */
    public boolean insertUser(UserModel userModel) {
        System.out.println("Halo");
        String sqlCode = "INSERT INTO user (email, firstname, lastname, password, registrationDate, role) VALUES (?,?,?,?,?,?)";
        System.out.println(appConfig.getDataSource().toString());
        return jdbcTemplate.update(sqlCode, userModel.getEmail(),
                userModel.getFirstname(),
                userModel.getLastname(),
                passwordEncoder.encode(userModel.getPassword()),
                userModel.getRegistrationDate(), "user") == 1;
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

    /**
     * A felhasználó bejelentkezését kezelő függvény
     * @param email A felhasználó email címe
     * @param password A fiók jelszava
     * @return true ha sikeres a bejelentkezés, false ha nem
     */
    public boolean loginUser(String email, String password) {
        return false;
    }
}
