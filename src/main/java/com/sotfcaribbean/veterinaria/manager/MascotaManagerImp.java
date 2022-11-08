package com.sotfcaribbean.veterinaria.manager;

import com.sotfcaribbean.veterinaria.dao.MascotaDao;
import com.sotfcaribbean.veterinaria.dto.Mascota;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class MascotaManagerImp implements MascotaManager{
    private final MascotaDao mascotaDao;

    public MascotaManagerImp(MascotaDao mascotaDao) {
        this.mascotaDao = mascotaDao;
    }

    @Override
    public void registrar(Mascota mascota) throws ExceptionManager {
        String mensaje;
        try {
            if (this.mascotaDao.consul(mascota.getIdMascota()) == null) {
                this.mascotaDao.insert(mascota);
                mensaje = "Se ha ingresado correctamente la mascota";
                System.out.println(mensaje);
            } else {
                mensaje = "La Mascota exite en la base de dato";
                System.out.println(mensaje);

            }

        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);
        }
    }

    @Override
    public void editar(Mascota mascota) throws ExceptionManager {
        String mensaje;
        try {
            if (this.mascotaDao.consul(mascota.getIdMascota()) != null) {
                this.mascotaDao.update(mascota);
                mensaje = "La Mascota se actualizo corrrectamente";
                System.out.println(mensaje);
            } else {
                mensaje = "la Mascota no exite en la base de dato";
                System.out.println(mensaje);

            }

        } catch (ExceptionDao e) {

            throw new ExceptionManager(e);
        }
    }

    @Override
    public void eliminar(Mascota mascota) throws ExceptionManager {
        String mensaje;
        try {
            Mascota masco = mascotaDao.consul(mascota.getIdMascota());
            if (masco == null) {
                mensaje = "La mascota no existe";
                System.out.println(mensaje);
            } else {
                mascotaDao.delete(mascota);
                mensaje = "La mascota se ha eliminado correctamente";
                System.out.println(mensaje);
            }
            System.out.println(mensaje);
        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);
        }
    }

    @Override
    public List<Mascota> listado() throws ExceptionManager {
        try {
            return mascotaDao.listado();
        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);
        }
    }
}
