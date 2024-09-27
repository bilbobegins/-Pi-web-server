package com.bilbobegins1997.toDoList.repository;

import com.bilbobegins1997.toDoList.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository    extends JpaRepository<ToDoList, Long> {

}
