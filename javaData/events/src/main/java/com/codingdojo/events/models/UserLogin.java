package com.codingdojo.events.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserLogin {
    @Email(message = "Email is required")
    private String loginEmail;
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String loginPassword;

    public UserLogin() {

    }

    public UserLogin(String loginEmail, String loginPassword) {
        this.setLoginEmail(loginEmail);
        this.setLoginPassword(loginPassword);
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

}
