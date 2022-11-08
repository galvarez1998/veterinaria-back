package com.sotfcaribbean.veterinaria.mapper;

import com.sotfcaribbean.veterinaria.dto.TipoEspecie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoEspecieMapper implements RowMapper<TipoEspecie> {
    @Override
    public TipoEspecie mapRow(ResultSet rs, int rowNum) throws SQLException {
        TipoEspecie tipoEspecie = new TipoEspecie();
        tipoEspecie.setIdEspecie(rs.getInt("idEspecie"));
        tipoEspecie.setNombre(rs.getString("nombre"));
        return tipoEspecie;
    }
}
