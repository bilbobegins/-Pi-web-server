package com.bilbobegins1997.toDoList.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class ToDoList {
    @Id
    private @GeneratedValue Long id;

    public ToDoList() {

    }

    public ToDoList( String type, String name) {
        this.type = type;
        this.name = name;
    }

    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDoList list)) return false;
        return Objects.equals(getId(),
                list.getId()) && Objects.equals(getType(),
                list.getType()) && Objects.equals(getName(),
                list.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getName());
    }

    @Override
    public String toString() {
        return "List{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
