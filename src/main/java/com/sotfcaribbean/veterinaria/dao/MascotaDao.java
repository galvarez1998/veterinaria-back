package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Mascota;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;

public interface MascotaDao {
    void insert(Mascota mascota) throws ExceptionDao;
    void update(Mascota mascota)throws ExceptionDao;
    void delete(Mascota mascota)throws ExceptionDao;
    Mascota consul(int id)throws ExceptionDao;
}