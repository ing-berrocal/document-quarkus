package com.avianca.model;

public record Tercero(
    Long uuid,
    String apellidos,
    String nombres,
    TipoDocumento tipoDocumento,
    String documento,
    String razonSocial) {
    
}
