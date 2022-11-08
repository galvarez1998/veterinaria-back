package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Mascota;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import com.sotfcaribbean.veterinaria.mapper.MascotaMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MascostaDaoImp implements MascotaDao {
    private final JdbcTemplate jdbcTemplate;

    public MascostaDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Mascota mascota) throws ExceptionDao {
        String INSERT = "INSERT INTO mascotas(idMascota,nombre,fecha_nac,fecha_reg,idCliente,idEspecie,raza) VALUES(?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(INSERT, mascota.getIdMascota(), mascota.getNombre(), mascota.getFecha_nac(),
                    mascota.getFecha_reg(), mascota.getIdCliente(),mascota.getIdEspecie(), mascota.getRaza());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public void update(Mascota mascota) throws ExceptionDao {
        String UPDATE = "UPDATE mascotas SET nombre = ?, fecha_nac = ?, fecha_reg= ?, raza = ?, idCliente = ?, idEspecie = ? " +
                "WHERE idMascota = ?";
        try {
            jdbcTemplate.update(UPDATE, mascota.getNombre(), mascota.getFecha_nac(),
                    mascota.getFecha_reg(), mascota.getRaza(), mascota.getIdCliente(),
                    mascota.getIdEspecie(), mascota.getIdMascota());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public void delete(Mascota mascota) throws ExceptionDao {
        String DELETE = "DELETE  FROM mascotas WHERE idMascota = ?";
        try {
            jdbcTemplate.update(DELETE, mascota.getIdMascota());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public Mascota consul(int id) {
        String SELECT = "SELECT idMascota,nombre,fecha_nac,fecha_reg,idCliente,idEspecie,raza FROM mascotas WHERE idMascota = ?";
        try {
            return jdbcTemplate.queryForObject(SELECT, new MascotaMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Mascota> listado() throws ExceptionDao {
        String SELECT = "SELECT idMascota,nombre,fecha_nac,fecha_reg,idCliente,idEspecie,raza FROM mascotas";
        List<Mascota> lista;

        try {
            lista = jdbcTemplate.query(SELECT, new MascotaMapper());

        } catch (Exception e) {
            throw new ExceptionDao(e);

        }
        return lista;
    }
}
