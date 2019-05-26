/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.listapi.controller;

import com.yritys.listapi.jpa.ToDo;
import com.yritys.listapi.service.ToDoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tommi
 */
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("todo")
public class ToDoController {
    
    @Autowired
    private ToDoService toDoService;
   
    // /todo -> palauttaa koko listan.
    @RequestMapping(method=RequestMethod.GET)
    public List todo(){
        return this.toDoService.getAllTasks();
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public void addToDo(@RequestBody ToDo todo){
       this.toDoService.addTask(todo);
    }
    
    // /todo/id -> palauttaa valitun ID:n tehtävän tiedot.
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Optional<ToDo> todoId(Model model, @PathVariable Long id){
         return this.toDoService.getTask(id);
    }
    
    // /todo/id -> muuta "done" boolean "true:ksi".
    @RequestMapping(value="/{id}", method=RequestMethod.PATCH)
    public void setDone(@PathVariable Long id){
        this.toDoService.setDone(id);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteToDo(@PathVariable Long id){
        this.toDoService.deleteTask(id);
    }
}
