package com.bilbobegins1997.toDoList.assembler;

import com.bilbobegins1997.toDoList.controller.TaskController;
import com.bilbobegins1997.toDoList.entity.ToDoList;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ListModelAssembler implements RepresentationModelAssembler<ToDoList, EntityModel<ToDoList>> {

    @Override
    public EntityModel<ToDoList> toModel(ToDoList list) {

        return EntityModel.of(list, //
                linkTo(methodOn(TaskController.class).one(list.getId())).withSelfRel(),
                linkTo(methodOn(TaskController.class).all()).withRel("list"));
    }
}
