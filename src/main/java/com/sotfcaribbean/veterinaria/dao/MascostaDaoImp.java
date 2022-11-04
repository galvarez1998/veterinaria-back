package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Mascota;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MascostaDaoImp implements MascotaDao{
    private JdbcTemplate jdbcTemplate;

    public MascostaDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Mascota mascota) throws ExceptionDao {

    }

    @Override
    public void update(Mascota mascota) throws ExceptionDao {

    }

    @Override
    public void delete(Mascota mascota) throws ExceptionDao {

    }

    @Override
    public Mascota consul(int id) throws ExceptionDao {
        return null;
    }
}
