package com.bilbobegins1997.toDoList.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("Could not find Type " + id);
    }
}
