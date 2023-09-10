package co.empresa.recursoshumanos.persistencia;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data

public class PerfilEmpleado {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column
    private int Tiempo;

    @Column
    private String Habilidades;

    @ManyToOne()
    @JoinColumn(name = "id_empleado")
    @Column
    private Empleado empleado;



}
