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
        mascota.setFecha_nac(rs.getDate("fecha_nac"));
        mascota.setFecha_reg(rs.getDate("fecha_reg"));
        mascota.setEspecie(rs.getString("especie"));
        mascota.setIdUsuario(rs.getInt("idCliente"));
        mascota.setIdRaza(rs.getInt("idRaza"));
        return mascota;
    }
}
