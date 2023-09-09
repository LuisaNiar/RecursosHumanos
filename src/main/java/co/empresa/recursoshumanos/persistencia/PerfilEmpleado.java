package co.empresa.recursoshumanos.persistencia;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
@Data

public class PerfilEmpleado {

    @Id
    @Column
    private int ID;

    @Column
    private int Tiempo;

    @Column
    private String Habilidades;

    @Column
    private int IdEmpleado;



}
