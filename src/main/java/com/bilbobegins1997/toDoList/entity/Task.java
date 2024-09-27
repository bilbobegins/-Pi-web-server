package com.bilbobegins1997.toDoList.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Task {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String task;

  public Task() {}

    Task(String name, String type) {

        this.name = name;
        this.task = type;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getTask() {
        return this.task;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTask(String role) {
        this.task = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task1)) return false;
        return Objects.equals(getId(), task1.getId()) && Objects.equals(getName(), task1.getName()) && Objects.equals(getTask(), task1.getTask());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTask());
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}