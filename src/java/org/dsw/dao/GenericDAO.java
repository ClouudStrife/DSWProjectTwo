/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dsw.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO<T>{
    private final EntityManagerFactory emf;
    
    public GenericDAO(){
        emf = Persistence.createEntityManagerFactory("DSWProject2PU");
    }
    
    protected EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    abstract T get(int id);
    abstract List<T> getAll();
    abstract void insert(T t);
    abstract void update(T t);
    abstract void delete(T t);
    
}
