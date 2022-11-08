package com.sotfcaribbean.veterinaria.controler;

import com.sotfcaribbean.veterinaria.dto.Cliente;
import com.sotfcaribbean.veterinaria.dto.Respuesta;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;
import com.sotfcaribbean.veterinaria.manager.ClienteManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@CrossOrigin("*")
public class ClienteControler {
    private final ClienteManager clienteManager;

    public ClienteControler(ClienteManager clienteManager) {
        this.clienteManager = clienteManager;
    }

    @PostMapping(path = "Cliente/registrar")
    public @ResponseBody void registrar(@RequestBody Cliente cliente) {
        try {
            clienteManager.registrar(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping (path = "Cliente/borra")
    public @ResponseBody void borrar(@RequestParam int documento) {
        Cliente cliente  = new Cliente();
        cliente.setDocumento(documento);
        try {
            clienteManager.eliminar(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping(path = "Cliente/lista")
    public Respuesta lista(){
        Respuesta respuesta = new Respuesta();
        try {
            List<Cliente> lista = clienteManager.listado();
            respuesta.setData(lista);
            respuesta.setCodigo(0);
        } catch (ExceptionManager e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }
    @PutMapping(path = "Cliente/actualizar")
    public @ResponseBody void actualizar(Cliente cliente){
        try {
            clienteManager.editar(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
