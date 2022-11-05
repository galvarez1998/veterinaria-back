package com.sotfcaribbean.veterinaria.manager;

import com.sotfcaribbean.veterinaria.dto.Cliente;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;

public interface ClienteManager {
    void registrar(Cliente cliente) throws ExceptionManager;
    void editar(Cliente cliente) throws ExceptionManager;
    void eliminar(Cliente cliente) throws ExceptionManager;
    void listar(Cliente cliente) throws ExceptionManager;
}
