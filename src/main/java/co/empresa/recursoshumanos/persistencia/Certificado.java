package co.empresa.recursoshumanos.persistencia;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data

public class Certificado {

    @Id
    @Column
    private int ID;

    @Column
    private String Certificados;

    @Column
    private int IdEmpleado;

}

