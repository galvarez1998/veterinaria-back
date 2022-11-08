package com.sotfcaribbean.veterinaria.manager;


import com.sotfcaribbean.veterinaria.dto.TipoEspecie;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;

public interface TipoEspecieManager {
    void registrar(TipoEspecie tipoEspecie) throws ExceptionManager;
    void editar(TipoEspecie tipoEspecie) throws ExceptionManager;
    void  eliminar(TipoEspecie tipoEspecie) throws ExceptionManager;
}
