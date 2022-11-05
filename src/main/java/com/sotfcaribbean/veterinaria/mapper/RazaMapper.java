package com.sotfcaribbean.veterinaria.mapper;

import com.sotfcaribbean.veterinaria.dto.Raza;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RazaMapper implements RowMapper<Raza> {
    @Override
    public Raza mapRow(ResultSet rs, int rowNum) throws SQLException {
        Raza raza = new Raza();
        raza.setIdRaza(rs.getInt("idRaza"));
        raza.setNombre(rs.getString("nombre"));
        return raza;
    }
}
