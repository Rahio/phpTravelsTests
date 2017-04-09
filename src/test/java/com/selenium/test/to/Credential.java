package com.selenium.test.to;

import java.util.Random;

/**
 * Created by Rahi on 2017-04-09.
 */
public class Credential {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String password;
    private String confirmationPassword;

    public Credential(String firstname, String lastname, String phone, String email, String password, String confirmationPassword) {
        this.firstname = generateNumberPrefix() + firstname;
        this.lastname = generateNumberPrefix() + lastname;
        this.phone = phone;
        this.email = generateNumberPrefix() + email;
        this.password = password;
        this.confirmationPassword = confirmationPassword;
    }

    public Credential(String phone) {
        this.firstname = "";
        this.lastname = "";
        this.phone = phone;
        this.email = "";
        this.password = "";
        this.confirmationPassword = "";
    }

    public Credential(String firstname, String lastname, String phone, String password, String confirmationPassword) {
        this.firstname = generateNumberPrefix() + firstname;
        this.lastname = generateNumberPrefix() + lastname;
        this.phone = phone;
        this.email = "user@phptravels.com";
        this.password = password;
        this.confirmationPassword = confirmationPassword;
    }

    private String generateNumberPrefix() {
        return String.valueOf(new Random().nextInt());
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }
}
