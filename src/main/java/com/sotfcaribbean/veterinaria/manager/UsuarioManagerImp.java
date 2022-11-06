package com.sotfcaribbean.veterinaria.manager;

import com.sotfcaribbean.veterinaria.dao.UsuarioDao;
import com.sotfcaribbean.veterinaria.dto.Usuario;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UsuarioManagerImp implements UsuarioManager{
    private final UsuarioDao usuarioDao;

    public UsuarioManagerImp(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public void editar(Usuario usuario) throws ExceptionManager {
        String mensaje;
        try {
            if (this.usuarioDao.consul(usuario.getIdUsuario()) != null) {
                this.usuarioDao.update(usuario);
                mensaje = "El Usuario se actualizo corrrectamente";
                System.out.println(mensaje);
            } else {
                mensaje = "El Usuario no exite en la base de dato";
                System.out.println(mensaje);
            }

        } catch (ExceptionDao e) {

            throw new ExceptionManager(e);
        }
    }

}
