package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.TipoEspecie;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import com.sotfcaribbean.veterinaria.mapper.TipoEspecieMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TipoEspecieDaoImp implements TipoEspecieDao {
    private final JdbcTemplate jdbcTemplate;

    public TipoEspecieDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(TipoEspecie tipoEspecie) throws ExceptionDao {
        String INSERT = "INSERT INTO tipoespecies(idEspecie,nombre)VALUES(?,?);";
        try {
            jdbcTemplate.update(INSERT, tipoEspecie.getIdEspecie(), tipoEspecie.getNombre());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public void update(TipoEspecie tipoEspecie) throws ExceptionDao {
        String UPDATE = "UPDATE tipoespecies SET nombre = ? WHERE idEspecie = ?";
        try {
            jdbcTemplate.update(UPDATE, tipoEspecie.getNombre(), tipoEspecie.getIdEspecie());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public void delete(TipoEspecie tipoEspecie) throws ExceptionDao {
        String DELETE = "DELETE  FROM tipoespecies WHERE idEspecie = ?";
        try {
            jdbcTemplate.update(DELETE, tipoEspecie.getIdEspecie());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public TipoEspecie consul(int id) {
        String SELECT = "SELECT idEspecie,nombre FROM tipoespecies WHERE idEspecie = ?";
        try {
            return jdbcTemplate.queryForObject(SELECT, new TipoEspecieMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
