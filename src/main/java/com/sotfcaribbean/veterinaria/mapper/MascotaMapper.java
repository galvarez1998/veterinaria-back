package com.sotfcaribbean.veterinaria.mapper;

import com.sotfcaribbean.veterinaria.dto.Mascota;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MascotaMapper implements RowMapper<Mascota> {
    @Override
    public Mascota mapRow(ResultSet rs, int rowNum) throws SQLException {
        Mascota mascota = new Mascota();
        mascota.setIdMascota(rs.getInt("idMascota"));
        mascota.setNombre(rs.getString("nombre"));
        mascota.setFecha_nac(rs.getString("fecha_nac"));
        mascota.setFecha_reg(rs.getString("fecha_reg"));
        mascota.setRaza(rs.getString("raza"));
        mascota.setIdCliente(rs.getInt("idCliente"));
        mascota.setIdEspecie(rs.getInt("idEspecie"));
        return mascota;
    }
}
