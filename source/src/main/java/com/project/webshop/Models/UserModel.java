package com.project.webshop.Models;

import java.time.LocalDateTime;

public class UserModel {
    private String email, password, firstname, lastname, role;
    private LocalDateTime registrationDate;

    public UserModel(String email, String password, String firstname, String lastname, String role, LocalDateTime registrationDate) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.registrationDate = registrationDate;
    }

    /**
     * Ez a függvény valósítja meg egy új felhasználó regisztrációját
     * @param firstname A felhasználó keresztneve
     * @param lastname A felhasználó vezetékneve
     * @param email A felhasználó email címe
     * @param password1 A felhasználó jelszava
     * @param password2 A felhasználó jelszava
     * @return true ha sikeres regisztráció, false ha nem
     */
    public boolean createUser(String firstname, String lastname, String email, String password1, String password2) {
        return false;
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
