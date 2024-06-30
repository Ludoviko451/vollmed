package com.laqf.api.controller;

import com.laqf.api.models.DatosActualizarMedico;
import com.laqf.api.models.DatosRegistroMedico;
import com.laqf.api.models.Medico;
import com.laqf.api.models.MedicoResponseDTO;
import com.laqf.api.repositorios.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datos) {
        medicoRepository.save(new Medico(datos));
    }

    @GetMapping
    public Page<MedicoResponseDTO> getAllMedicos(@PageableDefault(size = 10) Pageable pageable) {
        return medicoRepository.findByActivoTrue(pageable).map(MedicoResponseDTO::from);
    }

    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMedico(@PathVariable @NotNull Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
    }

}
