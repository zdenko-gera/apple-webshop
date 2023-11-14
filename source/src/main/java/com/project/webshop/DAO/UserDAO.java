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
        jdbcTemplate.setQueryTimeout(5);
    }

    /**
     * Ez a függvény valósítja meg egy új felhasználó beillesztését az adatbázisba. Az sql-ben a kérdőjelek helyére a
     * .update() fgv beilleszti a paraméterben kapott adatait. Az első paramétere maga az SQL kód. A jelszó hashelése a
     * SpringSecurity.passwordEncoder().encode() fgv-nyel valósul meg
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
     * A felhasználó bejelentkezését kezelő függvény. A kapott email címmel lekéri az ahhoz tartozó sort az adatbázisból. Ha
     * nincs olyan email címmel bejegyzés az adatbázisban, akkor visszaad false-t, ha van, akkor a
     * SpringSecurity.passwordEncoder().matches(password, user.getPassword()) fgv segítségével ellenőrzi, hogy a paraméterben
     * kapott jelszó megegyezik-e az adatbázisból lekért hashelt jelszóval. Ha igen, visszaad true-t, ha nem akkor false-ot.
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
     * @return true ha sikeres a törlés, false ha nem
     */
    public boolean deleteUser(String email) {
        String sqlCode = "DELETE FROM user WHERE email = ?";
        return jdbcTemplate.update(sqlCode, email) == 1;
    }

    /**
     * Lekér egy felhasználót az adatbázisból, amit egy Map-be rak bele. A .queryForMap() fgv azt csinálja, hogy ha talál
     * megfelelő sort az adatbázisban, akkor a Map-be hoz létre olyan bejegyzéseket, aminek a Kulcsa az attribútum neve az
     * adatbázisban, az értéke pedig az attribútum értéke. Például ha az adatbázisban az attribútum neve email, értéke
     * elek@elek.com akkor a Mapben lesz egy olyan bejegyzés, hogy "email" => "elek@elek.com", és ezt a Mapből a
     * 'valtozonev'.get("email")-el lehet elérni, ami a "elek@elek.com"-ot adja vissza. Ebből a Mapből hoz létre egy UserModelt,
     * és adja vissza.
     * @param email A lekérendő felhasználó email címe.
     * @return A megfelelő sorból készült UserModelt adja vissza
     */
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

    /**
     * A user jelszavát módosítja, majd az adatbázisba is bekerül a módosítás.
     * @param user
     * @param oldPassword
     * @param newPassword1
     * @param newPassword2
     */
    public void updateUserPasswordByEmail(UserModel user, String oldPassword, String newPassword1, String newPassword2) {
        user.setPassword(newPassword1);
        String sqlCode = "update user set password = '" + user.getPassword() + "' where email='" + user.getEmail() + "';";
        jdbcTemplate.update(sqlCode);
    }

    /**
     * Beállítja a user nevét a megadott stringekre, majd az adatbázisban is módosítja az adatokat.
     * @param user
     * @param firstname
     * @param lastname
     */
    public void updateUserNameByEmail(UserModel user, String firstname, String lastname){
        user.setFirstname(firstname);
        user.setLastname(lastname);
        String sqlCode = "update user set firstname = '"+firstname+"', lastname = '"+lastname+"' where email = '"+user.getEmail()+"';";
        jdbcTemplate.update(sqlCode);
    }
}
