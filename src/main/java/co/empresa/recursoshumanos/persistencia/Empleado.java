package co.empresa.recursoshumanos.persistencia;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
@Data

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int ID;

    @Column
    private String Nombre;

    @Column
    private String Apellido;

    @Column
    private int Cedula;

    @Column
    private int Telefono;

    @Column
    private String Puesto;

    @Column
    private int Salario;

    @Column
    private int vacaciones;

    @OneToMany(mappedBy = "certificado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificado> certificados;

    @OneToMany(mappedBy = "perfil_empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PerfilEmpleado> perfilEmpleados;

}
