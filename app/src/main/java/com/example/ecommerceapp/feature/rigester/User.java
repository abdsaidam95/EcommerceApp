package com.example.ecommerceapp.feature.rigester;

/**
 * @author by EngAbdSaidam
 * project commerce that support dataBinging and MvvMDesignPattern
 */


import java.io.Serializable;

public class User implements Serializable {
    private String id = "";
    private String email = "";
    private String username = "";
    private String phone = "";
    private String telefone = "";
    private String password = "";
    private String address = "";

    public User(String id, String email, String username, String phone, String telefone, String password, String address) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.telefone = telefone;
        this.password = password;
        this.address = address;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
