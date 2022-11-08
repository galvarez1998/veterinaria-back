package com.sotfcaribbean.veterinaria.controler;

import com.sotfcaribbean.veterinaria.dto.TipoEspecie;
import com.sotfcaribbean.veterinaria.manager.TipoEspecieManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
@CrossOrigin("*")
public class TipoEspecieControler {
    private final TipoEspecieManager tipoEspecieManager;

    public TipoEspecieControler(TipoEspecieManager tipoEspecieManager) {
        this.tipoEspecieManager = tipoEspecieManager;
    }

    @PostMapping(path = "/TipoEspecie/registrar")
    public @ResponseBody void registrar(@RequestBody TipoEspecie tipoEspecie) {
        try {
            tipoEspecieManager.registrar(tipoEspecie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/TipoEspecie/borra")
    public @ResponseBody void borrar(@RequestParam int id) {
        TipoEspecie tipoEspecie = new TipoEspecie();
        tipoEspecie.setIdEspecie(id);
        try {
            tipoEspecieManager.eliminar(tipoEspecie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/TipoEspecie/actualizar")
    public @ResponseBody void actualizar(TipoEspecie tipoEspecie) {
        try {
            tipoEspecieManager.editar(tipoEspecie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
