package com.bolsadeideas.ejemplo.banco.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.ejemplo.banco.entity.Cuenta;

@Repository("cuentaDao")
public class HibernateCuentaDao implements CuentaDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public Cuenta findById(int id) {
        return (Cuenta) sessionFactory.getCurrentSession().get(Cuenta.class, id);
    }

    @Transactional
    public void update(Cuenta cuenta) {
           sessionFactory.getCurrentSession().update(cuenta);
    }

}
