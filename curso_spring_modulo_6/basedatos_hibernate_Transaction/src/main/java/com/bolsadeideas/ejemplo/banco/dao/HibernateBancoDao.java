package com.bolsadeideas.ejemplo.banco.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.ejemplo.banco.entity.Banco;

@Repository("bancoDao")
public class HibernateBancoDao implements BancoDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public Banco findById(int id) {
        return (Banco) sessionFactory.getCurrentSession().get(Banco.class, id);
    }

    @Transactional
    public void update(Banco banco) {
           sessionFactory.getCurrentSession().update(banco);
    }

}

