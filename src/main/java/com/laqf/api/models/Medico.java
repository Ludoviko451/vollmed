package com.laqf.api.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "medicos")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;
    private String telefono;

    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    @Valid
    private Direccion direccion;

    public Medico(DatosRegistroMedico datos) {
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.documento = datos.documento();
        this.telefono = datos.telefono();
        this.especialidad = datos.especialidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public void actualizarDatos(DatosActualizarMedico datos) {
        if (datos.nombre() != null) {
            this.nombre = datos.nombre();
        }
        if (datos.documento() != null) {
            this.documento = datos.documento();
        }
        if (datos.direccion() != null) {
            this.direccion = direccion.actualizarDatos(datos.direccion());
        }
    }

    public void desactivarMedico() {
        this.activo = false;
    }
}
