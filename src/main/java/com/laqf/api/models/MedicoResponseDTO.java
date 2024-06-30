package com.laqf.api.models;

public record MedicoResponseDTO(
        Long id,
        String nombre,
        String especialidad,
        String documento,
        String email
){

    public static MedicoResponseDTO from(Medico medico) {
        return new MedicoResponseDTO(
                medico.getId(),
                medico.getNombre(),
                medico.getEspecialidad().toString(),
                medico.getDocumento(),
                medico.getEmail()
        );
    }
}
