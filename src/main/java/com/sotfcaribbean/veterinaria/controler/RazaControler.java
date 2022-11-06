package com.sotfcaribbean.veterinaria.controler;

import com.sotfcaribbean.veterinaria.dto.Raza;
import com.sotfcaribbean.veterinaria.manager.RazaManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
@CrossOrigin("*")
public class RazaControler {
    private final RazaManager razaManager;

    public RazaControler(RazaManager razaManager) {
        this.razaManager = razaManager;
    }

    @PostMapping(path = "/Raza/registrar")
    public @ResponseBody void registrar(@RequestBody Raza raza) {
        try {
            razaManager.registrar(raza);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/Raza/borra")
    public @ResponseBody void borrar(@RequestParam int id) {
        Raza raza = new Raza();
        raza.setIdRaza(id);
        try {
            razaManager.eliminar(raza);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/Cliente/actualizar")
    public @ResponseBody void actualizar(Raza raza) {
        try {
            razaManager.editar(raza);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
