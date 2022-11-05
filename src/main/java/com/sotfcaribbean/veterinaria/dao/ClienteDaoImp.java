package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Cliente;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import com.sotfcaribbean.veterinaria.mapper.ClienteMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteDaoImp implements ClienteDao {
    private final JdbcTemplate jdbcTemplate;

    public ClienteDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Cliente cliente) throws ExceptionDao {
        String INSERT = "INSERT INTO cliente(tipo_documento,documento,nombre,ciudad,direccion,telefono)VALUES(?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(INSERT, cliente.getTipoDocumento(), cliente.getDocumento(), cliente.getNombre(),
                    cliente.getCiudad(), cliente.getDireccion(), cliente.getTelefono());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public void update(Cliente cliente) throws ExceptionDao {
        String UPDATE = "UPDATE cliente SET tipo_documento = ?,nombre = ?,ciudad = ?,direccion = ?,telefono = ? WHERE documento = ?";
        try {
            jdbcTemplate.update(UPDATE, cliente.getTipoDocumento(), cliente.getNombre(),
                    cliente.getCiudad(), cliente.getDireccion(), cliente.getTelefono(), cliente.getDocumento());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public void delete(Cliente cliente) throws ExceptionDao {
        String DELETE = "DELETE  FROM cliente WHERE documento = ?";
        try {
            jdbcTemplate.update(DELETE, cliente.getDocumento());

        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public Cliente consul(int id) {
        String SELECT = "SELECT tipo_documento,documento,nombre,ciudad,direccion,telefono FROM cliente WHERE documento = ?";
        try {
            return jdbcTemplate.queryForObject(SELECT, new ClienteMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Cliente> listado() throws ExceptionDao {
        String SELECT = "SELECT tipo_documento,documento,nombre,ciudad,direccion,telefono FROM cliente ";
        List<Cliente> lista;

        try {
            lista = jdbcTemplate.query(SELECT, new ClienteMapper());

        } catch (Exception e) {
            throw new ExceptionDao(e);

        }
        return lista;

    }
}
