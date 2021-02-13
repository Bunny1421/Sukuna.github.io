package com.cpe.sukuna.controller;

import lombok.Data;

@Data
public class UserAddForm {

    private String name;

    private String email;

    private String password;

    public UserAddForm(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }



    public UserAddForm() {
    }
}
