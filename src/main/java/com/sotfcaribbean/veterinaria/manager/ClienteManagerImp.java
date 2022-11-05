package com.sotfcaribbean.veterinaria.manager;

import com.sotfcaribbean.veterinaria.dao.ClienteDao;
import com.sotfcaribbean.veterinaria.dto.Cliente;
import com.sotfcaribbean.veterinaria.exception.ExceptionDao;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ClienteManagerImp implements ClienteManager{
    private ClienteDao clienteDao;

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
                mensaje = "El usuario exite en la base de dato";
                System.out.println(mensaje);
                throw new ExceptionManager();
            }

        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);
        }
    }

    @Override
    public void editar(Cliente cliente) throws ExceptionManager {

    }

    @Override
    public void eliminar(Cliente cliente) throws ExceptionManager {
        String mensaje ;
        try {
            Cliente client = clienteDao.consul(cliente.getDocumento());
            if (client == null) {
                mensaje = "El usuario no existe";
                System.out.println(mensaje);
                throw new ExceptionManager();
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
    public void listar(Cliente cliente) throws ExceptionManager {

    }
}
