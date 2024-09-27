package com.bilbobegins1997.toDoList.controller;


import com.bilbobegins1997.toDoList.assembler.ListModelAssembler;
import com.bilbobegins1997.toDoList.entity.ToDoList;
import com.bilbobegins1997.toDoList.exception.ToDoListNotFoundException;
import com.bilbobegins1997.toDoList.repository.ToDoListRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.List;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin(origins = "https://arturprogramist.github.io", maxAge = 3600)
@RestController
@RequestMapping("/todo")
public class ListController {
    private final ToDoListRepository repository;

    private final ListModelAssembler assembler;

    ListController(ToDoListRepository repository, ListModelAssembler assembler){

        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/list")
    public CollectionModel<EntityModel<ToDoList>> all(){
        List<EntityModel<ToDoList>> list = repository.findAll().stream().map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(list, linkTo(methodOn(ListController.class).all()).withSelfRel());
    }
    @GetMapping("/list/{id}")
    public EntityModel<ToDoList> one(@PathVariable Long id){
        ToDoList toDoList = repository.findById(id).orElseThrow(()->new ToDoListNotFoundException(id));
        return assembler.toModel(toDoList);
    }

    @PostMapping("/list")
   public ToDoList newToDoList(@RequestBody ToDoList newList) {
        return repository.save(newList);
    }

    @PutMapping("/list/{id}")
    ToDoList replaceToDoList(@RequestBody ToDoList newToDoList, @PathVariable Long id) {

        return repository.findById(id)
                .map(toDoList -> {
                    toDoList.setName(newToDoList.getName());
                    toDoList.setType(newToDoList.getType());
                    return repository.save(toDoList);
                })
                .orElseGet(() -> repository.save(newToDoList));
    }

    @DeleteMapping("/list/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }




}
