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
    private int ID;

    @Column
    private int Tiempo;

    @Column
    private String Habilidades;

    @JoinColumn(name = "id_empleado")
    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Empleado empleado;



}
