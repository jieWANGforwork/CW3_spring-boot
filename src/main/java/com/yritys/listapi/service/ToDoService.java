/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.listapi.service;

import com.yritys.listapi.dao.JpaToDoDao;
import com.yritys.listapi.jpa.ToDo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tommi
 */
@Service
public class ToDoService {
    
    @Autowired
    private JpaToDoDao toDoDao;
    
    public List getAllTasks(){
        return this.toDoDao.getAll();
    }
    
    public void addTask(ToDo todo){
        this.toDoDao.save(todo);
    }
    
    public void deleteTask(Long id){
        this.toDoDao.delete(this.toDoDao.get(id).get());
    }
    
    public Optional<ToDo> getTask(Long id){
        return this.toDoDao.get(id);
    }
    
    public void setDone(Long id){
        ToDo todo = this.toDoDao.get(id).get();
        todo.setDone(true);
        this.toDoDao.save(todo);
    }
}
