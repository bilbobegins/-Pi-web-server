package com.bilbobegins1997.toDoList.exception;

public class ToDoListNotFoundException extends RuntimeException  {


    public ToDoListNotFoundException(Long id){
        super("Could not find employee " + id);
    }

}
