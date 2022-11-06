package com.sotfcaribbean.veterinaria.manager;

import com.sotfcaribbean.veterinaria.dto.Cliente;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;

import java.util.List;

public interface ClienteManager {
    void registrar(Cliente cliente) throws ExceptionManager;
    void editar(Cliente cliente) throws ExceptionManager;
    void eliminar(Cliente cliente) throws ExceptionManager;
    List<Cliente> listado() throws ExceptionManager;
}
