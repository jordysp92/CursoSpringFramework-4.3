package com.bolsadeideas.ejemplos.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.bolsadeideas.ejemplos.entity.Estudiante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Heredamos de JdbcDaoSupport que agrega una implementación de JdbcTemplate.
public class JdbcEstudianteDao extends JdbcDaoSupport implements EstudianteDao {

	public void save(Estudiante estudiante) {

		String sql = "INSERT INTO ESTUDIANTE (ID, NOMBRE, FECHA_NACIMIENTO, PROMEDIO) " + "VALUES (?, ?, ?, ?)";
		getJdbcTemplate().update(sql,
				new Object[] {estudiante.getId(), estudiante.getNombre(), 
						estudiante.getFechaNacimiento(), 
						estudiante.getPromedio() });
	}

	public Estudiante findById(int id) {
		return getJdbcTemplate().queryForObject("SELECT * FROM ESTUDIANTE WHERE ID = ?",
				BeanPropertyRowMapper.newInstance(Estudiante.class), id);
	}

	public void update(Estudiante estudiante) {
		String sql = "UPDATE ESTUDIANTE SET NOMBRE = ?, PROMEDIO = ?, FECHA_NACIMIENTO = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, 
				new Object[] { estudiante.getNombre(), 
						estudiante.getPromedio(), 
						estudiante.getFechaNacimiento(), 
						estudiante.getId() });
	}

	public void delete(Estudiante estudiante) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("id", estudiante.getId());
		getJdbcTemplate().update("DELETE FROM ESTUDIANTE WHERE ID = ?", args);
	}

	public List<Estudiante> findAll() {
		return getJdbcTemplate().query("SELECT * FROM ESTUDIANTE", BeanPropertyRowMapper.newInstance(Estudiante.class));
	}

	public String getNombre(int id) {
		return getJdbcTemplate().queryForObject("SELECT NOMBRE FROM ESTUDIANTE WHERE ID = ?", String.class, id);
	}

	public int count() {
		return getJdbcTemplate().queryForObject("SELECT COUNT(*) FROM ESTUDIANTE", Integer.class);
	}
}
