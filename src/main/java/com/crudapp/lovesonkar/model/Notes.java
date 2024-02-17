package com.crudapp.lovesonkar.model;

import jakarta.persistence.*;


@Entity
public class Notes {
    @Id
    @GeneratedValue
    private long id;
    private String notesitem;

    @ManyToOne
    private Users user;

    public Notes(long id, String notesitem) {
        this.id = id;
        this.notesitem = notesitem;
    }

    public Notes() {
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", notesitem='" + notesitem + '\'' +

                '}';
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
