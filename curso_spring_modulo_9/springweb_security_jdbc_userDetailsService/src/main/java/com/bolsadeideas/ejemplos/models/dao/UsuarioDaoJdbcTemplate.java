package com.bolsadeideas.ejemplos.models.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bolsadeideas.ejemplos.models.entity.Role;
import com.bolsadeideas.ejemplos.models.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoJdbcTemplate implements IUserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Usuario findByUsername(String username) {
		Usuario usuario = jdbcTemplate.queryForObject("SELECT id, username, password, enabled FROM users WHERE username = ?", BeanPropertyRowMapper.newInstance(Usuario.class), username);
		List<Role> roles  = jdbcTemplate.query("SELECT id, authority FROM authorities WHERE user_id = ?", BeanPropertyRowMapper.newInstance(Role.class), usuario.getId());
		usuario.setRoles(roles);
		return usuario;
	}

	@Override
	public List<Usuario> findAll() {
		return jdbcTemplate.query("SELECT * FROM users", BeanPropertyRowMapper.newInstance(Usuario.class));
	}

	@Override
	public Usuario findById(Integer id) {
		return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?",
				BeanPropertyRowMapper.newInstance(Usuario.class), id);
	}

	@Override
	public void save(Usuario user) {
		if(user.getId() > 0){
			jdbcTemplate.update("UPDATE users SET username = ?, password = ?, enabled = ? WHERE id = ?", 
					new Object[] { user.getUsername(), 
							user.getPassword(), 
							user.getEnabled(), 
							user.getId() });
		} else {
			jdbcTemplate.update("INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)", 
					new Object[] {user.getUsername(), user.getPassword(), user.getEnabled() });
		}
	}

	@Override
	public void delete(Usuario user) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("id", user.getId());
		jdbcTemplate.update("DELETE FROM users WHERE id = ?", args);
	}

}
