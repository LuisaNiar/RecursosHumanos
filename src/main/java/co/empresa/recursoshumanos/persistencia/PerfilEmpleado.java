package co.empresa.recursoshumanos.persistencia;

import lombok.Data;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;


@Entity
@Table
@Data

public class PerfilEmpleado {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int tiempo;

    @Column
    private String habilidades;

    @JoinColumn(name = "id_empleado")
    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Empleado empleado;



}
