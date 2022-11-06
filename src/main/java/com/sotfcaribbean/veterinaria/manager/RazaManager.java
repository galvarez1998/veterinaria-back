package com.sotfcaribbean.veterinaria.manager;


import com.sotfcaribbean.veterinaria.dto.Raza;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;

public interface RazaManager {
    void registrar(Raza raza) throws ExceptionManager;
    void editar(Raza raza) throws ExceptionManager;
    void  eliminar(Raza raza) throws ExceptionManager;
}
