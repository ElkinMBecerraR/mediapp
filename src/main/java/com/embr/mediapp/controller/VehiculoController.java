package com.embr.mediapp.controller;

import com.embr.mediapp.model.Vehiculo;
import com.embr.mediapp.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")

public class VehiculoController {

    @Autowired
    private IVehiculoService service;

    @PostMapping
    public Vehiculo registrar(@RequestBody Vehiculo v) throws Exception{
        return service.registrar(v);
    }

    @GetMapping
    public List<Vehiculo> listar() throws Exception{
        return service.listar();
    }

    @GetMapping("/{id}")
    public Vehiculo listarPorId(@PathVariable("id") Integer id) throws Exception{
        return service.listarPorId(id);
    }


    @PutMapping("/{id}")
    public Vehiculo modificar(@PathVariable("id") Integer id ,@RequestBody Vehiculo v) throws Exception{
        Vehiculo vh = service.listarPorId(id);
        if (vh != null) {
            v.setId(id);
            return service.modificar(v);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) throws Exception{
        service.eliminar(id);

    }
}
