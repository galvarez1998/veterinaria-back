package com.sotfcaribbean.veterinaria.manager;

import com.sotfcaribbean.veterinaria.dto.Usuario;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;


public interface UsuarioManager {
    void editar(Usuario usuario) throws ExceptionManager;
}
