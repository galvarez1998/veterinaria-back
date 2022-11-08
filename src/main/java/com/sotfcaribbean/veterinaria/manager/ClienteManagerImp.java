package com.sotfcaribbean.veterinaria.manager;

import com.sotfcaribbean.veterinaria.dao.ClienteDao;
import com.sotfcaribbean.veterinaria.dto.Cliente;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ClienteManagerImp implements ClienteManager {
    private final ClienteDao clienteDao;

    public ClienteManagerImp(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public void registrar(Cliente cliente) throws ExceptionManager {
        String mensaje;
        try {
            if (this.clienteDao.consul(cliente.getDocumento()) == null) {
                this.clienteDao.insert(cliente);
                mensaje = "Se ha ingresado correctamente el cliente";
                System.out.println(mensaje);
            } else {
                this.clienteDao.update(cliente);
                mensaje = "El usuario se actualizo en la base de datos";
                System.out.println(mensaje);

            }

        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);
        }
    }

    @Override
    public void editar(Cliente cliente) throws ExceptionManager {
        String mensaje;
        try {
            if (this.clienteDao.consul(cliente.getDocumento()) == null) {
                mensaje = "El Cliente no exite en la base de dato";
                System.out.println(mensaje);
            } else {
                this.clienteDao.update(cliente);
                mensaje = "El Cliente se actualizo corrrectamente";
                System.out.println(mensaje);
            }
        } catch (ExceptionDao e) {

            throw new ExceptionManager(e);
        }
    }

    @Override
    public void eliminar(Cliente cliente) throws ExceptionManager {
        String mensaje;
        try {
            Cliente client = clienteDao.consul(cliente.getDocumento());
            if (client == null) {
                mensaje = "El usuario no existe";
                System.out.println(mensaje);

            } else {
                clienteDao.delete(cliente);
                mensaje = "El usuario se ha eliminado correctamente";
                System.out.println(mensaje);
            }
        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);
        }
    }

    @Override
    public List<Cliente> listado() throws ExceptionManager {
        try {
            return clienteDao.listado();
        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);
        }
    }
}
