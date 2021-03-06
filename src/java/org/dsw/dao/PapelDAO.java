/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dsw.dao;

import org.dsw.pojo.Papel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PapelDAO extends GenericDAO<Papel> {

    @Override
    public void insert(Papel papel) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(papel);
        tx.commit();
        em.close();
    }

    @Override
    public List<Papel> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select p from Papel p", Papel.class);
        List<Papel> papeis = q.getResultList();
        em.close();
        return papeis;
    }

    @Override
    public void delete(Papel papel) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        papel = em.getReference(Papel.class, papel.getId());
        tx.begin();
        em.remove(papel);
        tx.commit();
    }

    @Override
    public void update(Papel papel) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(papel);
        tx.commit();
        em.close();
    }

    @Override
    public Papel get(Long id) {
        EntityManager em = this.getEntityManager();
        Papel papel = em.find(Papel.class, id);
        em.close();
        return papel;
    }

    public Papel getRole(String papel) {       
        EntityManager em = this.getEntityManager();
        Papel retPapel = em.find(Papel.class, papel);
        em.close();
        return retPapel;
    }
}
