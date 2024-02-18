package com.crudapp.lovesonkar.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Notes> notes = new ArrayList<>();

    @ManyToOne
    private AdminUser admin;

    public int getId() {
        return id;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes.add(notes);
    }

    public void setId(int id) {
        this.id = id;
    }


    public Users(int id, String username, String password, List<Notes> notes) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.notes = notes;
    }

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", notes=" + notes +
                '}';
    }
}


