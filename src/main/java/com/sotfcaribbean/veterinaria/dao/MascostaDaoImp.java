package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Mascota;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import com.sotfcaribbean.veterinaria.mapper.MascotaMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MascostaDaoImp implements MascotaDao{
    private final JdbcTemplate jdbcTemplate;

    public MascostaDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Mascota mascota) throws ExceptionDao {
        String INSERT = "INSERT INTO mascotas(idMascota,nombre,fecha_nac,fecha_reg,especie,idCliente,idRaza)" +
                        "VALUES(?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(INSERT, mascota.getIdMascota(), mascota.getNombre(), mascota.getFecha_nac(),
                    mascota.getFecha_reg(), mascota.getEspecie(), mascota.getIdUsuario(),
                    mascota.getIdRaza());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public void update(Mascota mascota) throws ExceptionDao {
        String UPDATE = "UPDATE mascotas SET nombre = ?, fecha_nac = ?, fecha_reg= ?, especie = ?, idCliente = ?, idRaza = ? " +
                        "WHERE idMascota = ?";
        try {
            jdbcTemplate.update(UPDATE, mascota.getNombre(), mascota.getFecha_nac(),
                    mascota.getFecha_reg(), mascota.getEspecie(), mascota.getIdUsuario(),
                    mascota.getIdRaza(),mascota.getIdMascota());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public void delete(Mascota mascota) throws ExceptionDao {
        String DELETE = "DELETE  FROM mascotas WHERE idMascota = ?";
        try {
            jdbcTemplate.update(DELETE,mascota.getIdMascota());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public Mascota consul(int id) {
        String SELECT = "SELECT idMascota,nombre,fecha_nac,fecha_reg,especie,idCliente,idRaza FROM mascotas";
        try {
            return jdbcTemplate.queryForObject(SELECT, new MascotaMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
