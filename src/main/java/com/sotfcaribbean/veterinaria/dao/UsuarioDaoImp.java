package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Usuario;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UsuarioDaoImp implements UsuarioDao {
    private JdbcTemplate jdbcTemplate;

    public UsuarioDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void update(Usuario user) throws ExceptionDao {

    }

    @Override
    public void delete(Usuario user) throws ExceptionDao {

    }

    @Override
    public Usuario consul(int id) throws ExceptionDao {
        return null;
    }

}
