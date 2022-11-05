package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Raza;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import com.sotfcaribbean.veterinaria.mapper.RazaMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RazaDaoImp implements RazaDao {
    private final JdbcTemplate jdbcTemplate;

    public RazaDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Raza raza) throws ExceptionDao {
        String INSERT = "INSERT INTO raza(idRaza,nombre)VALUES(?,?);";
        try {
            jdbcTemplate.update(INSERT, raza.getIdRaza(), raza.getNombre());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public void update(Raza raza) throws ExceptionDao {
        String UPDATE = "UPDATE raza SET nombre = ?, WHERE idRaza = ?";
        try {
            jdbcTemplate.update(UPDATE, raza.getNombre(), raza.getIdRaza());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public void delete(Raza raza) throws ExceptionDao {
        String DELETE = "DELETE  FROM raza WHERE idRaza = ?";
        try {
            jdbcTemplate.update(DELETE, raza.getIdRaza());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public Raza consul(int id) {
        String SELECT = "SELECT idRaza,nombre FROM raza WHERE idRaza = ?";
        try {
            return jdbcTemplate.queryForObject(SELECT, new RazaMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
