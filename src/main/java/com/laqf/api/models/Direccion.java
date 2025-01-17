package com.laqf.api.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private String numero;
    private String complemento;
    private String distrito;
    private String ciudad;

    public Direccion(DatosDireccion datos){
        this.calle = datos.calle();
        this.numero = datos.numero();
        this.distrito = datos.distrito();
        this.complemento = datos.complemento();
        this.ciudad = datos.ciudad();
    }

    public Direccion actualizarDatos(DatosDireccion direccion){
        if(direccion.calle() != null){
            this.calle = direccion.calle();
        }
        if(direccion.numero() != null){
            this.numero = direccion.numero();
        }
        if(direccion.distrito() != null){
            this.distrito = direccion.distrito();
        }
        if(direccion.complemento() != null){
            this.complemento = direccion.complemento();
        }
        if(direccion.ciudad() != null){
            this.ciudad = direccion.ciudad();
        }
        return this;
    }
}
