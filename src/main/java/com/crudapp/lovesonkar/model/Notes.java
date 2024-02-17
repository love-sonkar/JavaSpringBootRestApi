package com.crudapp.lovesonkar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Notes {
    @Id
    @GeneratedValue
    private long id;
    private String notesitem;

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", notesitem='" + notesitem + '\'' +
                '}';
    }

    public Notes(long id, String notesItem) {
        this.id = id;
        this.notesitem = notesItem;
    }

    public Notes() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNotesItem() {
        return notesitem;
    }

    public void setNotesItem(String notesItem) {
        this.notesitem = notesItem;
    }


}
