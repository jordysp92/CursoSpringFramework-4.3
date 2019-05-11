package com.bolsadeideas.ejemplo.banco.dao;

import com.bolsadeideas.ejemplo.banco.entity.Banco;

public interface BancoDao {
    public void update(Banco banco);
    public Banco findById(int id);
}
