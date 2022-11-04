package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Raza;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RazaDaoImp implements RazaDao{
    private JdbcTemplate jdbcTemplate;

    public RazaDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Raza raza) throws ExceptionDao {

    }

    @Override
    public void update(Raza raza) throws ExceptionDao {

    }

    @Override
    public void delete(Raza raza) throws ExceptionDao {

    }

    @Override
    public Raza consul(int id) throws ExceptionDao {
        return null;
    }
}
