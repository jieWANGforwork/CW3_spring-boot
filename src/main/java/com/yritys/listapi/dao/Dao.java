/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.listapi.dao;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author tommib Basic CRUD
 * @param <T>
 */
public interface Dao<T> {

    void save(T t); //(C)reate

    Optional<T> get(Long id); // (R)ead

    List<T> getAll(); //(R)ead

    void update(T t); // (U)pdate  

    void delete(T t); // (D)elete

}
