package com.embr.mediapp.impl;

import com.embr.mediapp.model.Paciente;
import com.embr.mediapp.repo.IPacienteRepo;
import com.embr.mediapp.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.embr.mediapp.repo.IGenericRepo;


@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService {

    @Autowired
    private IPacienteRepo repo;

    @Override
    protected IGenericRepo<Paciente, Integer> getRepo() {
        return repo;
    }
}
