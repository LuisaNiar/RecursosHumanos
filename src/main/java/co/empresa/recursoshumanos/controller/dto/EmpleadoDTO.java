package co.empresa.recursoshumanos.controller.dto;

import lombok.Data;

@Data
public class EmpleadoDTO {

    private String nombre;

    private String apellido;

    private int cedula;

    private long telefono;

    private String puesto;

    private int salario;

    private int vacaciones;

    private Boolean eliminado;

}
