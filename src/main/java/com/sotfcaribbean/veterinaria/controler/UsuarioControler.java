package com.sotfcaribbean.veterinaria.controler;

import com.sotfcaribbean.veterinaria.dto.Usuario;
import com.sotfcaribbean.veterinaria.manager.UsuarioManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
@CrossOrigin("*")
public class UsuarioControler {
    private final UsuarioManager usuarioManager;

    public UsuarioControler(UsuarioManager usuarioManager) {
        this.usuarioManager = usuarioManager;
    }
    @PutMapping(path = "/Usuario/actualizar")
    public @ResponseBody void actualizar(Usuario usuario){
        try {
            usuarioManager.editar(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
