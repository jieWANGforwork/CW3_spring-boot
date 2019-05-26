/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.listapi.dao;

import com.yritys.listapi.jpa.ToDo;
import com.yritys.listapi.jpa.ToDoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tommib
 */
@Repository
public class JpaToDoDao implements Dao<ToDo> {
    
    @Autowired
    private ToDoRepository toDoRepository;
    
    @Override
    public void save(ToDo t) {
      this.toDoRepository.saveAndFlush(t);
    }

    @Override
    public Optional<ToDo> get(Long id) {
        return this.toDoRepository.findById(id);
    }

    @Override
    public List<ToDo> getAll() {
        return this.toDoRepository.findAll();
    }

    @Override
    public void update(ToDo t) {
        this.toDoRepository.save(t);
    }

    @Override
    public void delete(ToDo t) {
        this.toDoRepository.delete(t);
    }
}
