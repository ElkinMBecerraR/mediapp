package com.embr.mediapp.impl;

import com.embr.mediapp.model.Medico;
import com.embr.mediapp.repo.IGenericRepo;
import com.embr.mediapp.repo.IMedicoRepo;
import com.embr.mediapp.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl extends CRUDImpl<Medico, Integer> implements IMedicoService {

    @Autowired
    private IMedicoRepo repo;

    @Override
    protected IGenericRepo<Medico, Integer> getRepo() {
        return repo;
    }
}
