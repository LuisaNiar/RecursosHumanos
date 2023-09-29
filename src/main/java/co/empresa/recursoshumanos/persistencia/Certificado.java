package co.empresa.recursoshumanos.persistencia;

import lombok.Data;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table
@Data

public class Certificado {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String certificados;

    @ManyToOne()
    @JoinColumn(name = "id_empleado")
    @JsonBackReference
    private Empleado empleado;

}

