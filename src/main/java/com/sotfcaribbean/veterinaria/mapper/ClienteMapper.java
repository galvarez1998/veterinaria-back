package com.sotfcaribbean.veterinaria.mapper;

import com.sotfcaribbean.veterinaria.dto.Cliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteMapper implements RowMapper<Cliente> {
    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setTipoDocumento(rs.getString("tipo_documento"));
        cliente.setDocumento(rs.getInt("documento"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setCiudad(rs.getString("ciudad"));
        cliente.setDireccion(rs.getString("direccion"));
        cliente.setTelefono(rs.getString("telefono"));
        return cliente;
    }
}
