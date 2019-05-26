/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.listapi.jpa;

import javax.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Tommi
 */
@Entity
public class ToDo extends AbstractPersistable<Long> {
    @Id
    @javax.persistence.Id
    private Long id;
    private String task;
    private String info;
    private boolean done;

    public ToDo(String task, String info) {
        this.task = task;
        this.info = info;
        this.done = false;
    }
    
    public ToDo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }    
}
