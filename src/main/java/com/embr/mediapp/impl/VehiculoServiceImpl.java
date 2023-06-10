package com.embr.mediapp.impl;

import com.embr.mediapp.model.Vehiculo;
import com.embr.mediapp.repo.IVehiculoRepo;
import com.embr.mediapp.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoRepo repo;

    @Override
    public Vehiculo registrar(Vehiculo v) throws Exception {
        return repo.save(v);
    }

    @Override
    public Vehiculo modificar(Vehiculo v) throws Exception {
        return repo.save(v);
    }

    @Override
    public List<Vehiculo> listar() throws Exception {
        return repo.findAll();
    }

    @Override
    public Vehiculo listarPorId(Integer id) throws Exception {
        Optional<Vehiculo> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Vehiculo();
    }

    @Override
    public void eliminar(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
