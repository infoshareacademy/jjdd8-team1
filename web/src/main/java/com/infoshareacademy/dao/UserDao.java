package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Book;
import com.infoshareacademy.domain.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public User findById(Long id) {
        Query query = em.createNamedQuery("User.getById");
        query.setParameter("id", id);
        return (User) query.getResultList().get(0);
    }
}
