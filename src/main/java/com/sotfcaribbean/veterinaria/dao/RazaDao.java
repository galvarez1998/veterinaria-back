package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Raza;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;

public interface RazaDao {
    void insert(Raza raza) throws ExceptionDao;
    void update(Raza raza)throws ExceptionDao;
    void delete(Raza raza)throws ExceptionDao;
    Raza consul(int id);
}
