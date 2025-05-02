package com.nikhil.todoapplication.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "to_do_list")
public class ToDoTask {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "status")
    private String status;

    public ToDoTask() {
    }

    public ToDoTask(String title, LocalDate date, String status) {
        this.title = title;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
