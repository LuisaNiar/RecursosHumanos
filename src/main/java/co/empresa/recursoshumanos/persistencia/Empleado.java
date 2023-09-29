package co.empresa.recursoshumanos.persistencia;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table
@Data

public class Empleado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int cedula;

    @Column
    private long telefono;

    @Column
    private String puesto;

    @Column
    private int salario;

    @Column
    private int vacaciones;

    @Column
    private boolean eliminado;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Certificado> certificados;


    @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private PerfilEmpleado perfilempleado;

}
