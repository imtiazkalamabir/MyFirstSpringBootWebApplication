package com.in28mintues.springboot.myfirstwebapp.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

// Database (MySQL)
// Static List of todos => Database (H2, MySQL)

// JPA
// Bean -> Database

// Entity allows to map a bean to a table.
// Spring boot auto config automatically start creating tables in H2 if it finds any entity
// here the To-do is mapped into TodoABC using @Entity(name = "TodoABC")
// but by default it will use the class name itself as Table name
// @Entity(name = "TodoABC")
@Entity
public class Todo {

    // @Id is used to define Primary Key
    // @GeneratedValue is used to generate id in a sequence
    @Id
    @GeneratedValue
    private int id;

    // Mapping username to a column "name"
    // @Column(name="name")
    private String username;

    // @Size is a validation annotation (Adding validation to Beans)
    @Size(min = 10, message = "Enter at least 10 character")
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public Todo() {

    }

    public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
