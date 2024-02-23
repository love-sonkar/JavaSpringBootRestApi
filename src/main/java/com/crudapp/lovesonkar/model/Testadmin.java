package com.crudapp.lovesonkar.model;

public class Testadmin {
    private int id;
    private String username;

    public Testadmin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Testadmin(int id, String username) {
        this.id = id;
        this.username = username;
    }
}
