package com.sotfcaribbean.veterinaria.dao;

import com.sotfcaribbean.veterinaria.dto.Usuario;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;


public interface UsuarioDao  {
    void update(Usuario user)throws ExceptionDao;
    Usuario consul(int id)throws ExceptionDao;
}
