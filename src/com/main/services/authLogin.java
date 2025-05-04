package com.main.services;

public class authLogin {

    public String validateLogin(String username, String password) {
        if (username.isEmpty() && password.isEmpty()) {
            return "USERNAME_PASSWORD_EMPTY";
        } else if (username.isEmpty()) {
            return "USERNAME_EMPTY";
        } else if (password.isEmpty()) {
            return "PASSWORD_EMPTY";
        } else if (!username.equals("admin") && !password.equals("admin")) {
            return "USERNAME_PASSWORD_WRONG";
        } else if (!username.equals("admin")) {
            return "USERNAME_WRONG";
        } else if (!password.equals("admin")) {
            return "PASSWORD_WRONG";
        } else {
            return "SUCCESS";
        }
    }

}
