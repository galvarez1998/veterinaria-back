package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Mascota;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;

import java.util.List;

public interface MascotaDao {
    void insert(Mascota mascota) throws ExceptionDao;
    void update(Mascota mascota)throws ExceptionDao;
    void delete(Mascota mascota)throws ExceptionDao;
    Mascota consul(int id);
    List<Mascota> listado() throws ExceptionDao;
}
