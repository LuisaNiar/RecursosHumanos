package co.empresa.recursoshumanos.controller.dto;

public class RespuestaDTO {

    String mensaje;

    public RespuestaDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public RespuestaDTO() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
