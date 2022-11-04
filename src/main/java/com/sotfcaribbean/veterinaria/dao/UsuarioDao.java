package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Usuario;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;

import java.util.List;

public interface UsuarioDao  {
    void insert(Usuario user) throws ExceptionDao;
    void update(Usuario user)throws ExceptionDao;
    void delete(Usuario user)throws ExceptionDao;
    Usuario consul(int id)throws ExceptionDao;
    List<Usuario> listado() throws ExceptionDao;
}
