package com.bolsadeideas.ejemplos.dao;

import java.util.List;

import com.bolsadeideas.ejemplos.entity.Estudiante;

public interface EstudianteDao {
	
    public void save(Estudiante estudiante);
    public void delete(Estudiante estudiante);
    public Estudiante findById(Integer id);
    public List<Estudiante> findAll();
}
