package com.embr.mediapp.service;

import com.embr.mediapp.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    Vehiculo registrar(Vehiculo v) throws Exception;
    Vehiculo modificar(Vehiculo v) throws Exception;
    List<Vehiculo> listar() throws Exception;
    Vehiculo listarPorId(Integer id) throws Exception;
    void eliminar(Integer id) throws Exception;
}
