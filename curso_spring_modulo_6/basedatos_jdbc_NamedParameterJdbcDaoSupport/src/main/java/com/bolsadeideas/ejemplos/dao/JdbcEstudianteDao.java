package com.bolsadeideas.ejemplos.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.bolsadeideas.ejemplos.entity.Estudiante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// NamedParameterJdbcDaoSupport hereda de JdbcDaoSupport y agrega una implementación de NamedParameterJdbcTemplat. 
public class JdbcEstudianteDao extends NamedParameterJdbcDaoSupport implements EstudianteDao {

	public void save(Estudiante estudiante) {

		String sql = "INSERT INTO ESTUDIANTE (ID, NOMBRE, FECHA_NACIMIENTO, PROMEDIO) "
				+ "VALUES (:id, :nombre, :fechaNacimiento, :promedio)";
		// BeanPropertySqlParameterSource() recibe el objeto entity (Objeto Java
		// con getter y setter) como parámetro
		// con todos los datos, automaticamente getSimpleJdbcTemplate ejecuta la
		// consulta.
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(estudiante);
		getNamedParameterJdbcTemplate().update(sql, parameterSource);
	}

	public Estudiante findById(int id) {
		String sql = "SELECT * FROM ESTUDIANTE WHERE ID = ?";

		BeanPropertyRowMapper<Estudiante> estudianteRowMapper = BeanPropertyRowMapper.newInstance(Estudiante.class);
		Estudiante estudiante = getJdbcTemplate().queryForObject(sql, estudianteRowMapper, id);

		return estudiante;
	}

	public void update(Estudiante estudiante) {
		String sql = "UPDATE ESTUDIANTE SET NOMBRE = :nombre, PROMEDIO = :promedio, FECHA_NACIMIENTO = :fechaNacimiento WHERE ID = :id";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(estudiante);
		getNamedParameterJdbcTemplate().update(sql, parameterSource);
	}

	public void delete(Estudiante estudiante) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("id", estudiante.getId());

		String sql = "DELETE FROM ESTUDIANTE WHERE ID = :id";
		getNamedParameterJdbcTemplate().update(sql, args);
	}

	public List<Estudiante> findAll() {
		String sql = "SELECT * FROM ESTUDIANTE";
		RowMapper<Estudiante> rm = BeanPropertyRowMapper.newInstance(Estudiante.class);
		List<Estudiante> estudiantes = getJdbcTemplate().query(sql, rm);

		return estudiantes;
	}

	public String getNombre(int id) {
		String sql = "SELECT NOMBRE FROM ESTUDIANTE WHERE ID = :id";
		SqlParameterSource namedParameters = 
                new MapSqlParameterSource("id", id);

		String nombre = getNamedParameterJdbcTemplate().queryForObject(sql, namedParameters, String.class);

		return nombre;
	}

	public int count() {
		String sql = "SELECT COUNT(*) FROM ESTUDIANTE";

		int count = getJdbcTemplate().queryForObject(sql, Integer.class);

		return count;
	}
}