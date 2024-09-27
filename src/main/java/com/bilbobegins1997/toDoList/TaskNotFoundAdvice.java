package com.bilbobegins1997.toDoList;
import com.bilbobegins1997.toDoList.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskNotFoundAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(TaskNotFoundException ex) {
        return ex.getMessage();
    }

}
