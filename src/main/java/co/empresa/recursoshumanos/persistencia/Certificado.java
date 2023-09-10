package co.empresa.recursoshumanos.persistencia;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data

public class Certificado {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column
    private String Certificados;

    @ManyToOne()
    @JoinColumn(name = "id_empleado")
    @Column
    private Empleado empleado;

}

