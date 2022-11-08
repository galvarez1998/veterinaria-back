package com.sotfcaribbean.veterinaria.manager;

import com.sotfcaribbean.veterinaria.dao.TipoEspecieDao;
import com.sotfcaribbean.veterinaria.dto.TipoEspecie;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TipoEspecieManagerImp implements TipoEspecieManager {
    private final TipoEspecieDao tipoEspecieDao;

    public TipoEspecieManagerImp(TipoEspecieDao tipoEspecieDao) {
        this.tipoEspecieDao = tipoEspecieDao;
    }

    @Override
    public void registrar(TipoEspecie tipoEspecie) throws ExceptionManager {
        String mensaje;
        try {
            if (this.tipoEspecieDao.consul(tipoEspecie.getIdEspecie()) == null) {
                this.tipoEspecieDao.insert(tipoEspecie);
                mensaje = "Se ha ingresado correctamente el tipo de especie";
                System.out.println(mensaje);
            } else {
                mensaje = " exite en la base de dato";
                System.out.println(mensaje);

            }

        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);
        }
    }

    @Override
    public void editar(TipoEspecie tipoEspecie) throws ExceptionManager {
        String mensaje;
        try {
            if (this.tipoEspecieDao.consul(tipoEspecie.getIdEspecie()) != null) {
                this.tipoEspecieDao.update(tipoEspecie);
                mensaje = "El tipo de especie se actualizo corrrectamente";
                System.out.println(mensaje);
            } else {
                mensaje = "El tipo de especie no exite en la base de dato";
                System.out.println(mensaje);
            }

        } catch (ExceptionDao e) {

            throw new ExceptionManager(e);
        }
    }

    @Override
    public void eliminar(TipoEspecie tipoEspecie) throws ExceptionManager {
        String mensaje;
        try {
            TipoEspecie tip = tipoEspecieDao.consul(tipoEspecie.getIdEspecie());
            if (tip == null) {
                mensaje = "el tipo de especie no existe";
                System.out.println(mensaje);

            } else {
                tipoEspecieDao.delete(tipoEspecie);
                mensaje = "el tipo de especie se ha eliminado correctamente";
                System.out.println(mensaje);
            }
        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);
        }
    }
}
