package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Cliente;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;

import java.util.List;

public interface ClienteDao {
    void insert(Cliente cliente) throws ExceptionDao;
    void update(Cliente cliente)throws ExceptionDao;
    void delete(Cliente cliente)throws ExceptionDao;
    Cliente consul(int id)throws ExceptionDao;
    List<Cliente> listado() throws ExceptionDao;
}
