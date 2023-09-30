package co.empresa.recursoshumanos.controller.dto;

import lombok.Data;

@Data
public class RespuestaDTO {

    String mensaje;

    public RespuestaDTO(String mensaje) {
        this.mensaje = mensaje;
    }



}
