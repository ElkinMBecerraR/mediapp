package com.embr.mediapp.controller;

import com.embr.mediapp.dto.PacienteDTO;
import com.embr.mediapp.exception.ModeloNotFoundException;
import com.embr.mediapp.model.Paciente;
import com.embr.mediapp.service.IPacienteService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listar() throws Exception{
        List<PacienteDTO> lista = service.listar().stream().map(p -> mapper.map(p, PacienteDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> listarPorId(@PathVariable("id") Integer id) throws Exception{
        PacienteDTO dtoResponse;
        Paciente obj = service.listarPorId(id);

        if(obj == null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }else {
            dtoResponse = mapper.map(obj, PacienteDTO.class);
        }

       return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    /*@PostMapping
    public ResponseEntity<PacienteDTO> registrar(@Valid @RequestBody PacienteDTO dtoRequest) throws Exception{
        Paciente p = mapper.map(dtoRequest, Paciente.class);
        Paciente obj = service.registrar(p);
        PacienteDTO dtoResponse = mapper.map(obj, PacienteDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }*/

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody PacienteDTO dtoRequest) throws Exception{
        Paciente p = mapper.map(dtoRequest, Paciente.class);
        Paciente obj = service.registrar(p);
        PacienteDTO dtoResponse = mapper.map(obj, PacienteDTO.class);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPaciente()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<PacienteDTO> modificar(@RequestBody PacienteDTO dtoRequest) throws Exception{
        Paciente pc = service.listarPorId(dtoRequest.getIdPaciente());

        if(pc == null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dtoRequest.getIdPaciente());
        }

        Paciente p = mapper.map(dtoRequest, Paciente.class);
        Paciente obj = service.modificar(p);
        PacienteDTO dtoResponse = mapper.map(obj, PacienteDTO.class);

        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{

        Paciente pc = service.listarPorId(id);

        if(pc == null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
