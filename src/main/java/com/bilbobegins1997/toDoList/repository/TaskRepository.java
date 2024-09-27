package com.bilbobegins1997.toDoList.repository;

import com.bilbobegins1997.toDoList.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface TaskRepository extends JpaRepository<Task, Long> {

}