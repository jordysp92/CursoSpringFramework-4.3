package com.bolsadeideas.ejemplos.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.ejemplos.entity.Estudiante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("estudianteDao")
public class JdbcEstudianteDao implements EstudianteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
    
	@Transactional
	public void save(Estudiante estudiante) {
		jdbcTemplate.update("INSERT INTO ESTUDIANTE (ID, NOMBRE, FECHA_NACIMIENTO, PROMEDIO) VALUES (?, ?, ?, ?)", 
				new Object[] {estudiante.getId(), estudiante.getNombre(), 
						estudiante.getFechaNacimiento(), 
						estudiante.getPromedio() });
	}

	@Transactional(readOnly = true)
	public Estudiante findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM ESTUDIANTE WHERE ID = ?",
				BeanPropertyRowMapper.newInstance(Estudiante.class), id);
	}

	@Transactional
	public void update(Estudiante estudiante) {
		jdbcTemplate.update("UPDATE ESTUDIANTE SET NOMBRE = ?, PROMEDIO = ?, FECHA_NACIMIENTO = ? WHERE ID = ?", 
				new Object[] { estudiante.getNombre(), 
						estudiante.getPromedio(), 
						estudiante.getFechaNacimiento(), 
						estudiante.getId() });
	}

	@Transactional
	public void delete(Estudiante estudiante) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("id", estudiante.getId());
		jdbcTemplate.update("DELETE FROM ESTUDIANTE WHERE ID = ?", args);
	}

	@Transactional(readOnly = true)
	public List<Estudiante> findAll() {
		return jdbcTemplate.query("SELECT * FROM ESTUDIANTE", BeanPropertyRowMapper.newInstance(Estudiante.class));
	}

	@Transactional(readOnly = true)
	public String getNombre(int id) {
		return jdbcTemplate.queryForObject("SELECT NOMBRE FROM ESTUDIANTE WHERE ID = ?", String.class, id);
	}

	@Transactional(readOnly = true)
	public int count() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ESTUDIANTE", Integer.class);
	}
}
