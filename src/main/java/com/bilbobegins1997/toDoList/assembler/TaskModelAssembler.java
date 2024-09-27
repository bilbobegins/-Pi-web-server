package com.bilbobegins1997.toDoList.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.bilbobegins1997.toDoList.controller.TaskController;
import com.bilbobegins1997.toDoList.entity.Task;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class TaskModelAssembler implements RepresentationModelAssembler<Task, EntityModel<Task>> {

    @Override
    public EntityModel<Task> toModel(Task employee) {

        return EntityModel.of(employee, //
                linkTo(methodOn(TaskController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(TaskController.class).all()).withRel("employees"));
    }
}
