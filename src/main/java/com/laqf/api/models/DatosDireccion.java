package com.laqf.api.models;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
        @NotBlank
        String calle,
        @NotBlank
        String ciudad,
        @NotBlank
        String numero,
        @NotBlank
        String distrito,
        @NotBlank
        String complemento
) {
}
