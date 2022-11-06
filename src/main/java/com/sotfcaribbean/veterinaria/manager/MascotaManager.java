package com.sotfcaribbean.veterinaria.manager;

import com.sotfcaribbean.veterinaria.dto.Mascota;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;

import java.util.List;

public interface MascotaManager {
    void registrar(Mascota mascota) throws ExceptionManager;
    void editar(Mascota mascota) throws ExceptionManager;
    void  eliminar(Mascota mascota) throws ExceptionManager;
    List<Mascota> listado() throws ExceptionManager;
}
