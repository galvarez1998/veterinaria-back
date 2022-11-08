package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.TipoEspecie;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;

public interface TipoEspecieDao {
    void insert(TipoEspecie tipoEspecie) throws ExceptionDao;
    void update(TipoEspecie tipoEspecie)throws ExceptionDao;
    void delete(TipoEspecie tipoEspecie)throws ExceptionDao;
    TipoEspecie consul(int id);
}
