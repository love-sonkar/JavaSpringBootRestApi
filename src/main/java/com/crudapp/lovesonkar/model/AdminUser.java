package com.crudapp.lovesonkar.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
public class AdminUser {

    @Id
    @GeneratedValue
    private int id;

    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private List<Users> userList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private List<Notes> notesList = new ArrayList<>();

    public AdminUser() {
    }

    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(Users userList) {
        this.userList.add(userList);
    }

    public List<Notes> getNotesList() {
        return notesList;
    }

    public void setNotesList(Notes notesList) {
        this.notesList.add(notesList);
    }

    public AdminUser(int id, String username, String password, List<Users> userList, List<Notes> notesList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userList = userList;
        this.notesList = notesList;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
