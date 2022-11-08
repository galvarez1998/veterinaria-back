package com.sotfcaribbean.veterinaria.controler;

import com.sotfcaribbean.veterinaria.dto.Mascota;
import com.sotfcaribbean.veterinaria.dto.Respuesta;
import com.sotfcaribbean.veterinaria.exception.ExceptionManager;
import com.sotfcaribbean.veterinaria.manager.MascotaManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@CrossOrigin("*")
public class MascotaControler {
    private final MascotaManager mascotaManager;

    public MascotaControler(MascotaManager mascotaManager) {
        this.mascotaManager = mascotaManager;
    }
    @PostMapping(path = "Mascota/registrar")
    public @ResponseBody void registrar(@RequestBody Mascota mascota) {
        try {
            mascotaManager.registrar(mascota);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping (path = "Mascota/borra")
    public @ResponseBody void borrar(@RequestParam int id) {
        Mascota mascota  = new Mascota();
        mascota.setIdMascota(id);
        try {
            mascotaManager.eliminar(mascota);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping(path = "Mascota/lista")
    public Respuesta lista(){
        Respuesta respuesta = new Respuesta();
        try {
            List<Mascota> lista = mascotaManager.listado();
            respuesta.setData(lista);
            respuesta.setCodigo(0);
        } catch (ExceptionManager e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }
    @PutMapping(path = "Mascota/actualizar")
    public @ResponseBody void actualizar(Mascota mascota){
        try {
            mascotaManager.editar(mascota);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
