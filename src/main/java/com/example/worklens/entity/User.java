package com.example.worklens.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @GeneratedValue @Id
    public Long user_id;

    @Column(name = "full_name")
    public String full_name;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    public User() {
    }

    //GETTER
    public Long getUser_id() {
        return user_id;
    }
    public String getFull_name() {
        return full_name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    //SETTER
    public void setUser_id(Long id) {
        this.user_id = id;
    }
    public void setFull_name(String name) {
        this.full_name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
