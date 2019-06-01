/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dsw.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.dsw.pojo.Locacao;



public class LocacaoDAO extends GenericDAO<Locacao>{

    @Override
    public Locacao get(Long id) {
        EntityManager em = this.getEntityManager();
        Locacao locacao = em.find(Locacao.class, id);
        em.close();
        return locacao;
    }

    @Override
    public List<Locacao> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select l from Locacao l", Locacao.class);
        List<Locacao> locacaos = q.getResultList();
        em.close();
        return locacaos; 
    }

    @Override
    public void insert(Locacao locacao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(locacao);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Locacao locacao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(locacao);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Locacao locacao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        locacao = em.getReference(Locacao.class, locacao.getId());
        tx.begin();
        em.remove(locacao);
        tx.commit();
    }
    
}
