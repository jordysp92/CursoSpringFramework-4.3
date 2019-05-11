package com.bolsadeideas.ejemplo.banco.dao;

import com.bolsadeideas.ejemplo.banco.entity.Cuenta;

public interface CuentaDao {
    public void update(Cuenta cuenta);
    public Cuenta findById(int id);
}
