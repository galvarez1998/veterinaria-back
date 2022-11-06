package com.sotfcaribbean.veterinaria.manager;

import com.sotfcaribbean.veterinaria.dao.RazaDao;
import com.sotfcaribbean.veterinaria.dto.Raza;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RazaManagerImp implements RazaManager{
    private final RazaDao razaDao;

    public RazaManagerImp(RazaDao razaDao) {
        this.razaDao = razaDao;
    }

    @Override
    public void registrar(Raza raza) throws ExceptionManager {
        String mensaje;
        try {
            if (this.razaDao.consul(raza.getIdRaza()) == null) {
                this.razaDao.insert(raza);
                mensaje = "Se ha ingresado correctamente la raza";
                System.out.println(mensaje);
            } else {
                mensaje = "La raza exite en la base de dato";
                System.out.println(mensaje);

            }

        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);
        }
    }

    @Override
    public void editar(Raza raza) throws ExceptionManager {
        String mensaje;
        try {
            if (this.razaDao.consul(raza.getIdRaza()) != null) {
                this.razaDao.update(raza);
                mensaje = "La Raza se actualizo corrrectamente";
                System.out.println(mensaje);
            } else {
                mensaje = "La Raza no exite en la base de dato";
                System.out.println(mensaje);
            }

        } catch (ExceptionDao e) {

            throw new ExceptionManager(e);
        }
    }

    @Override
    public void eliminar(Raza raza) throws ExceptionManager {
        String mensaje;
        try {
            Raza raz = razaDao.consul(raza.getIdRaza());
            if (raz == null) {
                mensaje = "La Raza no existe";
                System.out.println(mensaje);

            } else {
                razaDao.delete(raza);
                mensaje = "La Raza se ha eliminado correctamente";
                System.out.println(mensaje);
            }
        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);
        }
    }
}
